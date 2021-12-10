package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lw
 * @description SpringBootApplication启动类
 * @date 2021-12-09 11:43
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PayMenMain {
    public static void main(String[] args) {
        SpringApplication.run(PayMenMain.class,args);
    }
}
