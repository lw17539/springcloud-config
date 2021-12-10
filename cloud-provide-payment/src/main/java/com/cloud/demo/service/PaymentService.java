package com.cloud.demo.service;

import com.cloud.demo.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {
    int create(Payment payment);
    Payment queryById(@Param("id")Long id);
}
