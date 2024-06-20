package com.yangxh.cloud.controller;

import com.alibaba.fastjson2.JSON;
import com.yangxh.cloud.entities.Pay;
import com.yangxh.cloud.entities.PayDTO;
import com.yangxh.cloud.service.PayService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description 控制类
 * @Author yangxh8
 * @Date 2024/6/20 22:31
 */
@RequestMapping(value = "/pay")
@RestController
@Slf4j
public class PayController {
    @Resource
    private PayService payService;


    @PostMapping(value = "/add")
    public String addPay(@RequestBody Pay pay) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("PayController--addPay--pay={}", JSON.toJSONString(pay));
        }
        int count = payService.add(pay);
        return "成功插入记录，返回值：" + count;
    }
    
    @DeleteMapping(value = "/delete/{id}")
    public String deletePay(@PathVariable("id") Integer id) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("PayController--deletePay--id={}", JSON.toJSONString(id));
        }
        int count = payService.delete(id);
        return "成功删除记录，返回值：" + count;
    }

    @PutMapping(value = "/update")
    public String updatePay(@RequestBody PayDTO payDTO) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("PayController--updatePay--pay={}", JSON.toJSONString(payDTO));
        }
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int count = payService.update(pay);
        return "成功更新记录，返回值：" + count;
    }

    @GetMapping(value = "/get/{id}")
    public String getPayById(@PathVariable("id") Integer id) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("PayController--getPayById--id={}", JSON.toJSONString(id));
        }
        Pay pay = payService.getById(id);
        return "成功查询记录，返回值：" + JSON.toJSONString(pay);
    }

    @GetMapping(value = "/getAll")
    public String getAllPay() throws Exception {
        List<Pay> all = payService.getAll();
        return "查询所有记录，返回值：" + JSON.toJSONString(all);
    }
}
