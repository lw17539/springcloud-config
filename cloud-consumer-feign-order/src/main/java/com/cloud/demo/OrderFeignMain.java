package com.cloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lw
 * @description
 * @date 2021-12-10 14:24
 */
@SpringBootApplication
@EnableFeignClients //激活Feign的注解 需要加到主启动类上
public class OrderFeignMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain.class,args);
    }
}
