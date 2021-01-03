package com.springboot.service.impl;

import com.springboot.mapper.UserMapper;
import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisTemplate redisTemplate;
    private StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();

    @Override
    public List<User> getUserList() {
        redisTemplate.setKeySerializer(stringRedisSerializer);
        List<User> list= (List<User>) redisTemplate.opsForValue().get("userAll");
        if(list==null||list.isEmpty()){
            synchronized (this){
                list= (List<User>) redisTemplate.opsForValue().get("userAll");
                if(list==null||list.isEmpty()){
                    list=userMapper.selectAll();
                    redisTemplate.opsForValue().set("userAll",list);
                }
            }
        }
        return list;
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        //修改了数据库中的数据，修改后缓存中的数据和数据库中的不一致，导致不能及时的看到最新的信息
        //缓存中的数据为脏数据，
        // 解决方案3种
        // 1、修改完成数据库后更新缓存（不适合频繁修改）
        // 2、修改完成数据库后删除缓存数据（不适合频繁修改）
        // 3、不处理缓存使用定时任务定期更新缓存（适合频繁修改但是看到的数据不是最新的）
        //注意：如果一个数据频繁修改（并发修改）又要看到实时数据那么就不适合存入缓存中
        userMapper.updateByPrimaryKeySelective(user);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.delete("userAll");
    }

    @Override
    public void deleteUserById(Long id) {
        userMapper.deleteByPrimaryKey(id);
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.delete("userAll");
    }

    @Override
    public int login(User user) {
        User dbUser=userMapper.selectByUsername(user.getUsername());
        if(dbUser==null){
            return 1;
        }
        if(!dbUser.getPassword().equals(user.getPassword())){
            return 2;
        }
        //登录成功后将数据库中的User数据拷贝到参数对象的属性中
        BeanUtils.copyProperties(dbUser,user);
        return 0;
    }

    @Override
    public int add(User user) {
        try {
            //插入数据时会抛出异常DuplicateKeyException 抛出这个异常表示违反数据库的唯一约束，表示账号已经存在
            userMapper.insert(user);
        } catch (DuplicateKeyException e) {
            return  1;
        }
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.delete("userAll");
        return 0;
    }
}
