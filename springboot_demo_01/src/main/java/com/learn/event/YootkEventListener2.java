package com.learn.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

/**
 * @Description 事件监听器
 * @Author yangxh8
 * @Date 2023/4/5 14:40
 */
@Configuration
public class YootkEventListener2 {
    private static final Logger log = LoggerFactory.getLogger(YootkEventListener2.class);

    @EventListener(classes = {YootkEvent.class})
    @Async
    public void onApplicationEvent(YootkEvent yootkEvent) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (log.isInfoEnabled()) {
            log.info("异步监听方式，事件源={}", yootkEvent.getSource());
        }
    }
}
