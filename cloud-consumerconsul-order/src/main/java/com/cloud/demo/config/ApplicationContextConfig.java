package com.cloud.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lw
 * @description 配置文件
 * @date 2021-12-10 10:18
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    // RestTemplate
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
