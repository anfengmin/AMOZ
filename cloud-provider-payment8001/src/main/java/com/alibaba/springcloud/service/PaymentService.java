package com.alibaba.springcloud.service;

import com.alibaba.springcloud.dao.PaymentMapper;
import com.alibaba.springcloud.model.Payment;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @program: cloud2020
 * @description:
 * @author: anfm
 * @create: 2020-07-04 21:17
 **/
@Service
public class PaymentService {

    @Resource
    private PaymentMapper paymentMapper;

    public int create(Payment payment){
        return paymentMapper.insert(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentMapper.getPaymentById(id);
    }

}
