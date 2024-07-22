package com.yangxh.cloud.controller;

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
@RequestMapping(value = "/consumer")
public class OrderController {
    //    public static final String PaymentSrv_URL = "http://localhost:8001";//先写死，硬编码
    public static final String PaymentSrv_URL = "http://cloud-payment-service";//服务注册中心上的微服务名称
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
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/delete" + id, id, ResultData.class);
    }

    // 修改操作
    @GetMapping("/pay/getAll")
    public ResultData getAll() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/getAll", ResultData.class);
    }

    @GetMapping(value = "/pay/get/info")
    private ResultData getInfoByConsul() {
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/info", ResultData.class);
    }

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/discovery")
    public String discovery() {
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            System.out.println(element);
        }

        System.out.println("===================================");

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }

        return instances.get(0).getServiceId() + ":" + instances.get(0).getPort();
    }
}
