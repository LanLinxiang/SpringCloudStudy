package com.llx.springcloud.controller;

import com.llx.springcloud.entities.CommonResoult;
import com.llx.springcloud.entities.Payment;
import com.llx.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {
    @Resource
    private OrderService orderService;

    @GetMapping("/consumer/payment/getEnt/{id}")
    CommonResoult<Payment> getPaymentByIdEnt(@PathVariable("id") Long id){
        return orderService.getPaymentByIdEnt(id);
    }
}
