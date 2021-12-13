package com.cloud.demo.controller;

import com.cloud.demo.entity.CommonResult;
import com.cloud.demo.entity.Payment;
import com.cloud.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lw
 * @description
 * @date 2021-12-10 14:30
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Autowired
    private PaymentService paymentService;

    /**
     * @description
     * @param id
     * @return com.cloud.demo.entity.CommonResult<com.cloud.demo.entity.Payment>
     */
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        CommonResult result = paymentService.queryById(id);
        return result;
    }

    /**
     * @description
     * @param
     * @return 超时时间
    */
    @GetMapping("/consumer/feign/timeout")
    public String paymentFeignTimeOut() throws InterruptedException{
        return paymentService.PaymentFeignTimeOut();
    }
}
