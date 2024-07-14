package com.yangxh.cloud.controller;

import com.yangxh.cloud.entities.PayDTO;
import com.yangxh.cloud.resp.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * @Description
 * @Author yangxh8
 * @Date 2024/7/11 22:45
 */
@RestController
@RequestMapping(value = "/consumer")
public class OrderController {
//    public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码
    public static final String PaymentSrv_URL = "http://cloud-consumer-order";//服务注册中心上的微服务名称
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 一般情况下，通过浏览器的地址栏输入url，发送的只能是get请求
     * 我们底层调用的是post方法，模拟消费者发送get请求，客户端消费者
     * 参数可以不添加@RequestBody
     *
     * @param payDTO
     * @return
     */
    @PostMapping("/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }

    // 删除+修改操作作为家庭作业，O(∩_∩)O。。。。。。。
    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);
    }

    // 删除
    @DeleteMapping("/pay/delete/{id}")
    public ResultData deletePay(@PathVariable("id") Integer id) {
//        restTemplate.delete(PaymentSrv_URL + "/pay/delete/" + id);
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/delete"+id, id, ResultData.class);
    }

    // 修改操作
    @PutMapping("/pay/update")
    public ResultData updatePay(PayDTO payDTO) {
        return restTemplate.patchForObject(PaymentSrv_URL + "/pay/update", payDTO, ResultData.class);
    }
}
