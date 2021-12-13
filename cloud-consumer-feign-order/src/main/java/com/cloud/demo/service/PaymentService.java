package com.cloud.demo.service;

import com.cloud.demo.entity.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lw
 * @description
 * @date 2021-12-10 14:26
 */
@ComponentScan
@FeignClient(value = "mcroservice-payment")//使用Feign,使用哪个微服务
public interface PaymentService {
    //调用生产者微服务的名称为mcroservice-payment下边的接口
    @GetMapping("/payment/get/{id}")
    public CommonResult queryById(@PathVariable("id")Long id);
    // 调用生产者微服务名称为mcroservice-payment下边的模拟超时接口
    @GetMapping("/payment/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException;
}
