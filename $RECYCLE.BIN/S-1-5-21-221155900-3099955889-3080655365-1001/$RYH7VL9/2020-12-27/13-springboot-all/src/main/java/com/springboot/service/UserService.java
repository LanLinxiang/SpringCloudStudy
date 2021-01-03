package com.springboot.service;

import com.springboot.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUserById(Long id);

    void update(User user);

    void deleteUserById(Long id);

    int login(User user);

    int add(User user);
}
