package com.learn.event;

import org.springframework.context.ApplicationEvent;

/**
 * @Description 自定义事件
 * @Author yangxh8
 * @Date 2023/4/5 14:06
 */
public class YootkEvent extends ApplicationEvent {
    /**
     * 构造函数
     * @param source 事件源随意定义
     */
    public YootkEvent(Object source) {
        super(source);
    }
}
