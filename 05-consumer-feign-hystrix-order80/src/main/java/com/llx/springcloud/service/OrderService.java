package com.llx.springcloud.service;


import com.llx.springcloud.entities.CommonResoult;
import com.llx.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT" ,fallback = OrderServiceHystrix.class)
//这里去调用spring.application.name: cloud-eureka-client-payment-service的Controller
public interface OrderService {
    @GetMapping("/payment/hystrix/paymentok/get/{id}")
    public String paymentCOK(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystrix/paymentTimeOutt/get/{id}")
    public String paymentTimeOutt(@PathVariable("id") Integer id);
}
