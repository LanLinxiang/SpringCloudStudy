package com.springboot.service;

import com.springboot.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Title: UserService
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-20
 */

public interface UserService {
    void addUser(User user);
    List<User> selectUser();
}
