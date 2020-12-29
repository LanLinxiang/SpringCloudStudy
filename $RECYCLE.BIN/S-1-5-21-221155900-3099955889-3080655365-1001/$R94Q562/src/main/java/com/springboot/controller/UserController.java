package com.springboot.controller;

import com.springboot.model.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: UserController
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-20
 */
@Controller
public class UserController {
@Autowired
    private UserService userService;
@RequestMapping("/addUser")
    public @ResponseBody String addUser(User user){
    userService.addUser(user);
    return "+1";

}

    @RequestMapping("/selectUser")
    public @ResponseBody String selectUser(){
    return userService.selectUser().toString();
    }
}
