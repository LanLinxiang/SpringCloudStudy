package com.springcloud.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 *  当前项目是一个SpringCloud的服务消费者，因此可以返回Json数据或页面视图
 *  我们这里标记@RestController仅仅为了方便测试
 */
@RestController
public class ConsumerController {
    /**
     * 注入一个RestTemplate模板对象，这个类是SpringWeb提供者，可以使用这个对象，使用Http协议访问任意一个
     * 基于Http的远程请求。
     * 注意：
     *   这个对象默认Spring并没有声明到Spring的应用上下文容器中，因此必须要手动声明，具体参考自定义类 RestTemplateConfig
     */
    @Resource
    private RestTemplate restTemplate;
    @RequestMapping("/consumerTest")
    public Object test(){
        /**
         * getForEntity 方法使用Http协议以Get方法提交请求，访问服务提供者，对应服务提供者的@RequestMapping或@GetMapping
         * 参数 1 为本次请求的具体地址路径
         * 参数 2 为本次请求的具体响应数据类型
         * 注意：
         *   1、如果远程服务提供者返回的数据是一个基本数据格式例如字符串或数字则可以使用String.class或对应的包装类.class
         *   封装响应的具体数据
         * 返回值类型ResponseEntity<T>:这个对象是Spring的响应封装对象，这个对象用于封装响应的数据，包括响应头、响应状态码、
         * 响应体（响应的具体数据），其中泛型决定响应体中的数据类型取值由getForEntity的参数2决定
         */
        String url="http://localhost:8081/providerTest";
        ResponseEntity<String> result=restTemplate.getForEntity(url,String.class);
        System.out.println(result.getHeaders());//获取响应头
        System.out.println(result.getStatusCode());//获取响应状态信息
        System.out.println(result.getStatusCodeValue());//获取响应状态码 例如200 或404
        String body=result.getBody();//获取响应体
        return "SpringCloud的服务提供者-----"+body;
    }
}
