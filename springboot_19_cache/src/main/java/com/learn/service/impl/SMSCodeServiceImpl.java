package com.learn.service.impl;

import com.learn.domain.SMSCode;
import com.learn.service.SMSCodeService;
import com.learn.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yangxh8
 * @Date 2023/2/16 20:32
 */
@Service
public class SMSCodeServiceImpl implements SMSCodeService {
    @Autowired
    private CodeUtil codeUtil;

    @Override
//    @Cacheable(value = "smsCode", key = "#tele")
    @CachePut(value = "smsCode", key = "#tele")
    public String sendCode(String tele) {
        String generator = codeUtil.generator(tele);
        return generator;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String tele = smsCode.getTele();
        String code = smsCode.getCode();
        return codeUtil.getCode(tele).equals(code);
    }
}
