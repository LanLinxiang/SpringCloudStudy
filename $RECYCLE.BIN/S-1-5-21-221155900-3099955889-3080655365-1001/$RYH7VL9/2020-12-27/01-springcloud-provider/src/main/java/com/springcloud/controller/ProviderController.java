package com.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  @RestController 注解标记当前类是一个SpringMVC的控制器类
 *  但是要求这个控制器类中所有的控制器方法全部默认返回Json格式的数据，相当于是@Controller与@ResponseBody的组合
 *  注意：
 *    由于当前项目是一个SpringCloud的服务提供者因此需要有能力接收Http请求并返回Json数据，因此我们标记了@RestController
 */
@RestController
public class ProviderController {

    @RequestMapping("/providerTest")
    public Object test(){

        return "第一个SpringCloud服务提供者";
    }
}
