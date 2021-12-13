package com.cloud.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lw
 * @description 更改负载算法，自定义配置，修改轮询方法替换为随机算法
 * @date 2021-12-10 11:41
 */
@Configuration
public class MyselfRule {
    @Bean
    public IRule myRule(){
        // 定义为随机
        return new RoundRobinRule();
    }
}
