package com.learn.controller;

import com.learn.domain.SMSCode;
import com.learn.service.SMSCodeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author yangxh8
 * @Date 2023/2/16 20:33
 */
@Slf4j
@RestController
@RequestMapping(value = "/sms")
public class SMSCodeController {
    @Autowired
    private SMSCodeService smsCodeService;

    @GetMapping
    public String sendCode(String tele) {
        return smsCodeService.sendCode(tele);
    }

    @PostMapping
    public boolean checkCode(@RequestBody SMSCode smsCode) {
        if (log.isInfoEnabled()) {
            log.info("校验请求={}", smsCode);
        }
        return smsCodeService.checkCode(smsCode);
    }
}
