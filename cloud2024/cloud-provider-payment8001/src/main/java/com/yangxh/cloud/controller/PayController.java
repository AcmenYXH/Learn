package com.yangxh.cloud.controller;

import com.alibaba.fastjson2.JSON;
import com.yangxh.cloud.entities.Pay;
import com.yangxh.cloud.entities.PayDTO;
import com.yangxh.cloud.resp.ResultData;
import com.yangxh.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    @Resource
    private PayService payService;


    @PostMapping(value = "/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public ResultData<String> addPay(@RequestBody Pay pay) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("PayController--addPay--pay={}", JSON.toJSONString(pay));
        }
        int count = payService.add(pay);
//        return "成功插入记录，返回值：" + count;
        return ResultData.success("成功插入记录，返回值：" + count);
    }
    
    @DeleteMapping(value = "/delete/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<String> deletePay(@PathVariable("id") Integer id) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("PayController--deletePay--id={}", JSON.toJSONString(id));
        }
        int count = payService.delete(id);
//        return "成功删除记录，返回值：" + count;
        return ResultData.success("成功删除记录，返回值：" + count);

    }

    @PutMapping(value = "/update")
    @Operation(summary = "更新", description = "修改支付流水方法")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("PayController--updatePay--pay={}", JSON.toJSONString(payDTO));
        }
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);
        int count = payService.update(pay);
//        return "成功更新记录，返回值：" + count;
        return ResultData.success("成功更新记录，返回值：" + count);
    }

    @GetMapping(value = "/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData<Pay> getPayById(@PathVariable("id") Integer id) throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("PayController--getPayById--id={}", JSON.toJSONString(id));
        }
        Pay pay = payService.getById(id);
//        return "成功查询记录，返回值：" + pay;
        return ResultData.success(pay);

    }

    @GetMapping(value = "/getAll")
    @Operation(summary = "查询全部流水",description = "查询全部支付流水方法")
    public ResultData<List<Pay>> getAllPay() throws Exception {
        List<Pay> all = payService.getAll();
        return ResultData.success(all);
    }
}
