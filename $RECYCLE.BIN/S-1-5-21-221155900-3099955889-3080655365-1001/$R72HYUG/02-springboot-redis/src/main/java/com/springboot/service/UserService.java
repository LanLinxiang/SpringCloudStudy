package com.springboot.service;

import com.springboot.model.User;

import java.util.List;

/**
 * Title: UserService
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-21
 */
public interface UserService {
    List<User> selectAll();
}
