package com.learn.service;

import com.learn.domain.SMSCode;

/**
 * @Description
 * @Author yangxh8
 * @Date 2023/2/16 20:31
 */
public interface SMSCodeService {
    String sendCode(String tele);

    boolean checkCode(SMSCode smsCode);
}
