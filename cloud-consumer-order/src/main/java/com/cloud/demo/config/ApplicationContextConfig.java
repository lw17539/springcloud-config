package com.cloud.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author lw
 * @description
 * @date 2021-12-09 14:19
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    //restTemplate 的负载均衡能力
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
