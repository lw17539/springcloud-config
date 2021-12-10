package com.cloud.demo.service.impl;

import com.cloud.demo.dao.PaymentMapper;
import com.cloud.demo.entity.Payment;
import com.cloud.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lw
 * @description PaymentService的实现类
 * @date 2021-12-09 11:59
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentMapper mapper;

    @Override
    public int create(Payment payment) {
        return mapper.create(payment);
    }

    @Override
    public Payment queryById(Long id) {
        return mapper.queryById(id);
    }
}
