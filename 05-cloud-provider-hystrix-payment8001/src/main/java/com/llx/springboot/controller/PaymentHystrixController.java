package com.llx.springboot.controller;

import com.llx.springboot.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;

@RestController
public class PaymentHystrixController {
    @Resource
    private PaymentHystrixService paymentService;
    @Value("${server.port}")
    private String serverport;

    @GetMapping("/payment/hystrix/paymentok/get/{id}")
    public String paymentCOK(@PathVariable("id") Integer id){
        String result = paymentService.PaymentOk(id);

        return result;

    }

    @GetMapping("/payment/hystrix/paymentTimeOutt/get/{id}")
    public String paymentTimeOutt(@PathVariable("id") Integer id){
        String result = paymentService.PaymentTimeOut(id);
        return result;
    }


    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);

        return result;
    }
}
