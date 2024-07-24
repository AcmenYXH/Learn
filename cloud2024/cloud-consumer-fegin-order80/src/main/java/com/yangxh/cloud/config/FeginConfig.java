package com.yangxh.cloud.config;

import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description Fegin的重试机制
 * @Author yangxh
 * @Date 2024/7/24 21:10
 */
@Configuration
public class FeginConfig {

    @Bean
    public Retryer myRetryer() {
        // 默认重试机制是不开启的
//        return Retryer.NEVER_RETRY;
        // 最大请求次数为3(1(Default)+2)，初始间隔时间为100ms，重试间最大间隔时间为1s
        return new Retryer.Default(100, 1, 3);
    }
}
