package com.cloud.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lw
 * @description
 * @date 2021-12-10 16:56
 */
@Configuration
public class FeignConfig {

    /**
     * feignClient 配置日志级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel(){
        // 请求和响应的头信息，请求和响应的正文及元数据
        return Logger.Level.FULL;
    }
}
