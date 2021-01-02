package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Title: HelloSpringBootController
 * Description:
 *
 * @author LanLinxiang
 * @version V1.0
 * @email linxianglan@aliyun.com
 * @date 2020-12-21
 */
@Controller
public class HelloSpringBootController {
    @RequestMapping("/test")
    public @ResponseBody String sayHi(){
        return "hello,springBoot";
    }
}

