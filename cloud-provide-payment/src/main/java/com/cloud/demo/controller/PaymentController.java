package com.cloud.demo.controller;

import cn.hutool.Hutool;
import com.cloud.demo.config.IpConfiguration;
import com.cloud.demo.entity.CommonResult;
import com.cloud.demo.entity.Payment;
import com.cloud.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lw
 * @description
 * @date 2021-12-09 12:02
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private IpConfiguration ip;

    /**
     * 注入服务发现的注解
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 模拟业务接口延时3秒
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/feign/timeout")
    public String PaymentFeignTimeOut() throws InterruptedException{
        TimeUnit.SECONDS.sleep(3);
        Integer port = ip.getServerPort();
        return port.toString();
    }

    /**
     *  获取服务信息
     * @return DiscoveryClient
     */
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        services.forEach(s -> log.info("*****注册到eureka中的服务有："+services));
        List<ServiceInstance> instances = discoveryClient.getInstances("MCROSERVICE-PAYMENT");
        instances.forEach(s -> log.info("当前服务的实例有"+s.getServiceId()+"\t"+s.getHost()+"\t"+s.getPort()+"\t"+s.getUri()));
        return this.discoveryClient;
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("****新增成功****" + i);
        if(i > 0){
            return new CommonResult(200,"插入数据库成功:"+ip.getServerPort(),i);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("****查询成功****"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功:"+ip.getServerPort(),payment);
        }else{
            return new CommonResult(444,"查询失败",null);
        }
    }
}
