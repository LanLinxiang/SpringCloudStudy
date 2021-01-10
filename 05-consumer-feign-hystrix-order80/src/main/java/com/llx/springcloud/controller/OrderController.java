package com.llx.springcloud.controller;

import com.llx.springcloud.entities.CommonResoult;
import com.llx.springcloud.entities.Payment;
import com.llx.springcloud.service.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
//@DefaultProperties(defaultFallback = "paymentTimeOutFallbackMethod")
public class OrderController {
    @Resource
    private OrderService orderService;



    @GetMapping("/consumer/payment/hystrix/paymentok/get/{id}")
    public String paymentCOK(@PathVariable("id") Integer id){

        return orderService.paymentCOK(id);
    }



    //特制fallback
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "5000")  //3秒钟以内就是正常的业务逻辑
    })
    @GetMapping("/consumer/payment/hystrix/paymentTimeOutt/get/{id}")
    public String paymentTimeOutt(@PathVariable("id") Integer id){

        return orderService.paymentTimeOutt(id);
    }


    //特制兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对付支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,(┬＿┬)";
    }

}
