package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lw
 * @description 启动类
 * @date 2021-12-10 09:53
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain04 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain04.class,args);
    }
}
