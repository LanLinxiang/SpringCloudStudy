package com.springboot.mapper;

import com.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User record);


    List<User> selectUser();
}