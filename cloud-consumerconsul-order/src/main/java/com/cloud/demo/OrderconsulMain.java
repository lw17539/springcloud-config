package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author lw
 * @description 主启动类
 * @date 2021-12-10 10:16
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderconsulMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderconsulMain.class,args);
    }
}
