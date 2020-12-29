package com.springboot.service.impl;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Title: UserServiceImpl
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-21
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private RedisTem


    @Override
    public List<User> selectAll() {
        return null;
    }
}
