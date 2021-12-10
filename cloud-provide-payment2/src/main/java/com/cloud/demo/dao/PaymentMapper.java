package com.cloud.demo.dao;

import com.cloud.demo.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lw
 * @description
 * @date 2021-12-09 11:43
 */
@Mapper
@Repository
public interface PaymentMapper {
    int create(Payment payment);
    Payment queryById(@Param("id")Long id);
}
