package com.cloud.demo.controller;

import com.cloud.demo.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lw
 * @description
 * @date 2021-12-13 11:26
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystirxController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    String paymentInfo_ok(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentInfo_ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
//    } )
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id")Integer id){
        return paymentHystrixService.paymentinfo_TimeOut(id);
    }


    // 服务降级的兜底方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id")Integer id){
        return "我是消费者（端口）80，对方支付系统繁忙，请稍后再试。o(-..-)o";
    }

    /**
     * 消费者80的全局fallback
     * @return
     */
    public String payment_Global_FallbackMethod(){
        return "Global异常处理信息，请稍后在重试";
    }
}
