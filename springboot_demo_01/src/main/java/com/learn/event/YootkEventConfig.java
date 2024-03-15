package com.learn.event;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 配置类
 * @Author yangxh8
 * @Date 2023/4/5 14:44
 */
@Configuration
public class YootkEventConfig {
    @Bean
    public YootkEventListener eventListener() {
        return new YootkEventListener();
    }
}
