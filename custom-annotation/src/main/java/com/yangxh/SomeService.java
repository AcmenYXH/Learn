package com.yangxh;

import com.yangxh.config.MyRetry;
import org.springframework.stereotype.Component;

/**
 * @Description 业务逻辑处理
 * @Author yangxh8
 * @Date 2024/5/8 11:40
 */
@Component
public class SomeService {
    static int runCount = 0;
    @MyRetry(max_retry_count = 3,forExection = {Exception.class}, forRollback = "fallbackMethod")
    public void someMethodThatMayFail() {
        System.out.println("执行业务逻辑");
        runCount++;
        String a = null;
        byte[] bytes = a.getBytes();
    }

    public void fallbackMethod() {
        System.out.println("重试次数="+runCount);
        System.out.println("失败重试后调用回退处理逻辑");
    }
}
