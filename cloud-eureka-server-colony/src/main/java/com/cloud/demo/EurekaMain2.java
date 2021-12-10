package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author lw
 * @description
 * @date 2021-12-09 15:58
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaMain2 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMain2.class,args);
    }
}