package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lw
 * @description
 * @date 2021-12-09 16:29
 */
@SpringBootApplication
@EnableEurekaClient
public class PayMenMain2 {
    public static void main(String[] args) {
        SpringApplication.run(PayMenMain2.class,args);
    }
}