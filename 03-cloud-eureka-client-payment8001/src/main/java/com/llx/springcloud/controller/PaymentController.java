package com.llx.springcloud.controller;


import com.llx.springcloud.entities.CommonResoult;
import com.llx.springcloud.entities.Payment;
import com.llx.springcloud.service.PaymentService;
import com.netflix.loadbalancer.IRule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController

public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverport;

    @PostMapping(value = "/payment/creat")
    public CommonResoult creat(Payment payment){

        int result = paymentService.create(payment);
        System.out.println("111");

        if(0<result){
            return new CommonResoult(200,"插入成功",result);

        }else {
            return new CommonResoult(404,"插入失败",null);
        }
    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResoult getPaymentById(@PathVariable("id") Long id){
        Payment paymentById = paymentService.getPaymentById(id);
        System.out.println("111111");
        if(null != paymentById){
            return new CommonResoult(201,"查询成功"+serverport,paymentById);
        }else {
            return new CommonResoult(404,"查询失败",null);
        }

    }

    @GetMapping(value = "/payment/lb")

    public CommonResoult lbPayment(){
        return new CommonResoult(111,serverport,null);
    }


}
