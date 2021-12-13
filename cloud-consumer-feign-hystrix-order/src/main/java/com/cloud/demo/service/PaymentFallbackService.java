package com.cloud.demo.service;

import org.springframework.stereotype.Component;

/**
 * @author lw
 * @description
 * @date 2021-12-13 14:49
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String paymentInfo_ok(Integer id) {
        return "PaymentFallbackService fall paymentInfo_OK 服务器出现故障，请稍后再试或者联系管理员解决！ð";
    }

    @Override
    public String paymentinfo_TimeOut(Integer id) {
        return "PaymentFallbackService fall paymentInfo_TimeOut 服务器出现故障，请稍后再试或者联系管理员解决！ð";
    }
}
