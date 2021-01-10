package com.llx.springcloud.config;

import com.llx.springcloud.entities.Payment;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    //将RestTemplate 封装到Spring 中
    @Bean
    public RestTemplate restTemplate(){

        return new RestTemplate();
    }
}
