package com.learn.util;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yangxh8
 * @Date 2023/2/16 20:36
 */
@Component
public class CodeUtil {
    private final String a[] = {"000000", "00000", "0000", "000", "00", "0", ""};

    public String generator(String tele) {
        int hash = tele.hashCode();
        int encryption = 20230216;
        long result = hash ^ encryption;
        long timeMillis = System.currentTimeMillis();
        result = result ^ timeMillis;
        String code = Math.abs(result % 1000000) + "";
        int length = code.length();
        return a[length] + code;
    }

    @Cacheable(value = "smsCode", key = "#tele")
    public String getCode(String tele) {
        return "";
    }

//    public static void main(String[] args) {
//        String generator = (new CodeUtil()).generator("18312341236");
//        System.out.println(generator);
//    }
}
