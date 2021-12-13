package com.cloud.demo;

import com.cloud.myrule.MyselfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author lw
 * @description 启动类
 * @date 2021-12-09 14:17
 */
@SpringBootApplication
@EnableEurekaClient
// name为生产者服务的服务名称 configuration为配类的类名
@RibbonClient(name = "mcroservice-payment",configuration = MyselfRule.class)
public class OrderMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain.class,args);
    }
}
