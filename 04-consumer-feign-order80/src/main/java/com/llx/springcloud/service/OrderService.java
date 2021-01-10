package com.llx.springcloud.service;


import com.llx.springcloud.entities.CommonResoult;
import com.llx.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-EUREKA-CLIENT-PAYMENT-SERVICE")
//这里去调用spring.application.name: cloud-eureka-client-payment-service的Controller
public interface OrderService {
    @GetMapping("/payment/get/{id}")
    CommonResoult<Payment> getPaymentByIdEnt(@PathVariable("id") Long id);
}
