package com.springboot.controller;

import com.springboot.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Title: Thymeleaf
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-23
 */

@RestController
@Controller
public class ThymeleafController {
    @RequestMapping("/index")
    public String testThymeleaf(Model model){
        User user =new User("张三",15);
        model.addAttribute("user",user);
        model.addAttribute("data","dataaa");
        return "index";
    }
}
