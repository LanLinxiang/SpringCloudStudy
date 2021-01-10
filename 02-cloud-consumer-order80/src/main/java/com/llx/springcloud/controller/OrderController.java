package com.llx.springcloud.controller;



import com.llx.springcloud.entities.CommonResoult;
import com.llx.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderController {
    private String url_8001="http://localhost:8001/";
    @Resource
    private RestTemplate restTemplate;




    /**对应8001工程的PaymentController
     * @PostMapping(value = "/payment/creat")
     * public CommonResoult creat(Payment payment)
     * */

    @GetMapping("/consumer/payment/creat")
    public CommonResoult<Payment> creat(Payment payment){
        return restTemplate.postForObject(url_8001+"/payment/creat",payment,CommonResoult.class);
    }

    /**对应8001工程的PaymentController
     * @GetMapping(value = "/payment/get/{id}")
     * public CommonResoult getPaymentById(@PathVariable("id") Long id)
     * */

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResoult<Payment> getPaymentById(@PathVariable("id") Long id){
        return restTemplate.getForObject(url_8001+"/payment/get/"+id,CommonResoult.class);
    }



}
