package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author lw
 * @description
 * @date 2021-12-13 16:35
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboarMain {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboarMain.class,args);
    }
}
