package com.yangxh.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.yangxh.cloud.api.PayFeginApi;
import com.yangxh.cloud.entities.PayDTO;
import com.yangxh.cloud.resp.ResultData;
import com.yangxh.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description
 * @Author yangxh8
 * @Date 2024/7/11 22:45
 */
@RestController
@RequestMapping(value = "/fegin")
public class OrderController {
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private PayFeginApi payFeginApi;

    @PostMapping("/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return payFeginApi.addOrder(payDTO);
    }

    @GetMapping("/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        ResultData resultData = null;

        try {
            log.error("OrderController--getPayInfo--调用开始={}", DateUtil.now());
            resultData = payFeginApi.getPayInfo(id);
        } catch (Exception e) {
            log.error("OrderController--getPayInfo--调用失败={},error=", DateUtil.now(), e);
            return ResultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
        }
        return resultData;
    }

    @GetMapping(value = "/get/info")
    private ResultData getInfoByConsul() {
        return payFeginApi.getInfoByConsul();
    }
}
