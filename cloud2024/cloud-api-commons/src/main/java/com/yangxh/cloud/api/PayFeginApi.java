package com.yangxh.cloud.api;

import com.yangxh.cloud.entities.PayDTO;
import com.yangxh.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @Description 支付公用API模块
 * @Author yangxh
 * @Date 2024/7/23 21:51
 */
@FeignClient(value = "cloud-payment-service")
public interface PayFeginApi {
    /**
     * 新增一条支付相关流水记录
     *
     * @param payDTO
     * @return
     */
    @PostMapping("/pay/add")
    ResultData addOrder(@RequestBody PayDTO payDTO);

    /**
     * 查询支付记录
     *
     * @param id:
     * @return: com.yangxh.cloud.resp.ResultData
     * @author yangxh
     * @date 2024/7/23 22:07
     **/
    @GetMapping("/pay/get/{id}")
    ResultData getPayInfo(@PathVariable("id") Integer id);

    /**
     * openfeign天然支持负载均衡演示
     *
     * @return: com.yangxh.cloud.resp.ResultData
     * @author yangxh
     * @date 2024/7/23 22:08
     **/
    @GetMapping("/pay/get/info")
    ResultData getInfoByConsul();

    /**
     * Resilience4j CircuitBreaker 的例子
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id);
}
