package com.yangxh.cloud.controller;

import com.yangxh.cloud.api.PayFeginApi;
import com.yangxh.cloud.entities.PayDTO;
import com.yangxh.cloud.resp.ResultData;
import jakarta.annotation.Resource;
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
    @Resource
    private PayFeginApi payFeginApi;

    @PostMapping("/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return payFeginApi.addOrder(payDTO);
    }

    @GetMapping("/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return payFeginApi.getPayInfo(id);
    }

    @GetMapping(value = "/get/info")
    private ResultData getInfoByConsul() {
        return payFeginApi.getInfoByConsul();
    }
}
