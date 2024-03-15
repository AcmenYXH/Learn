package com.learn.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;

/**
 * @Description 事件监听器
 * @Author yangxh8
 * @Date 2023/4/5 14:40
 */
public class YootkEventListener implements ApplicationListener<YootkEvent> {
    private static final Logger log = LoggerFactory.getLogger(YootkEventListener.class);

    @Override
    public void onApplicationEvent(YootkEvent yootkEvent) {
        if (log.isInfoEnabled()) {
            log.info("事件源={}", yootkEvent.getSource());
        }
    }
}
