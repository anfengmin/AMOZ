package com.alibaba.springcloud.controller;

import com.alibaba.springcloud.utils.CommonResult;
import com.alibaba.springcloud.model.Payment;
import com.alibaba.springcloud.service.PaymentService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: cloud2020
 * @description:
 * @author: anfm
 * @create: 2020-07-04 21:23
 **/
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @PostMapping(value = "/pament/create")
    public CommonResult create(Payment payment){
        int result = paymentService.create(payment);
        log.info("******插入结果："+result);
        if( result > 0){
            return new CommonResult(200,"插入数据成功",result);
        } else {
            return new CommonResult(444,"插入数据失败 ",null);
        }
    }

    @GetMapping(value = "/pament/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id );
        log.info("******查询结果："+payment);
        if( payment != null){
            return new CommonResult(200,"查询成功",payment);
        } else {
            return new CommonResult(444,"没有对应id ",null);
        }
    }
}
