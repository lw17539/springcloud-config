package com.cloud.demo.controller;

import com.cloud.demo.config.IpConfiguration;
import com.cloud.demo.entity.CommonResult;
import com.cloud.demo.entity.Payment;
import com.cloud.demo.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        int i = paymentService.create(payment);
        log.info("****新增成功****" + i);
        if(i > 0){
            return new CommonResult(200,"插入数据库成功"+ip.getServerPort(),i);
        }else{
            return new CommonResult(444,"插入数据库失败",null);
        }
    }

    @GetMapping("/get/{id}")
    public CommonResult queryById(@PathVariable("id") Long id){
        Payment payment = paymentService.queryById(id);
        log.info("****查询成功****"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功"+ip.getServerPort(),payment);
        }else{
            return new CommonResult(444,"查询失败",null);
        }
    }
}
