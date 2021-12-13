package com.cloud.demo.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author lw
 * @description
 * @date 2021-12-10 18:13
 */
@Service
public class PaymentService {

    //在微服务中使用Hystrix 作为断路器时，通常涉及到以下三个重要的指标参数
    //（这里是写在@HystrixProperties注解中，当然实际项目中可以全局配置在yml或properties中）
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(Integer id){
        if(id < 0){
            throw new RuntimeException("*********id 不能为负数");
        }
        String seriaNumber = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t"+"调用成功，流水号：" + seriaNumber;
    }

    //兜底降级
    public String paymentCircuitBreaker_fallback(Integer id){
        return "id 不能为负数，请稍后再试～～～～ID：" +id;
    }

    /**
     * @description  正常访问
     * @param id
     * @return
    */
    public String paymentInfo_ok(Integer id){
        return "线程池：" + Thread.currentThread().getName() + "paymentInfo_ok,id:" + id +"\t" + "正常访问～～～～";
    }

    /**
     * @description 超时访问
     * @param id
     * @return
    */
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHabdler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds"
                    ,value = "3000")
    })
    public String paymentInfo_TimeOut(Integer id){
        // 业务层访问时间过长
//        int timeNumber = 3;
        try {
            // 暂停 3 秒钟
            TimeUnit.MILLISECONDS.sleep(800);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 运行异常的服务降级
        //int age = 2/0;

        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut,id:" + id
                +"\t" + "~~~~----～～～～   耗时（秒）" ;
    }

    /**
     * 超时访问到这里兜底
     *
     * @param id
     * @return
     */
    public String paymentInfo_TimeOutHabdler(Integer id){
        return "线程池：" + Thread.currentThread().getName()
                + " paymentInfo_TimeOutHabdler,id :" + id + "\t"
                + "系统繁忙，请稍后再试*******o(__)o";
    }
}
