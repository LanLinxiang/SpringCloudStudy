package com.llx.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class OrderServiceHystrix implements OrderService {
    @Override
    public String paymentCOK(Integer id) {
        return "444";
    }

    @Override
    public String paymentTimeOutt(Integer id) {
        return "444";
    }
}
