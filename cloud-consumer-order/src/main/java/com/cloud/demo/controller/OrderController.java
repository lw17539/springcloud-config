package com.cloud.demo.controller;

import com.cloud.demo.entity.CommonResult;
import com.cloud.demo.entity.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author lw
 * @description 消费者的业务调用接口
 * @date 2021-12-09 14:21
 */
@RestController
@Slf4j
public class OrderController {

    // 调用支付订单服务端的ip+端口号
    public static final String PAYMENT_URL = "http://MCROSERVICE-PAYMENT";

    @Autowired
    private RestTemplate restTemplate;
    // 创建支付订单的接口
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }

    // 获取id 获取支付订单
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable("id")Long id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }
}
