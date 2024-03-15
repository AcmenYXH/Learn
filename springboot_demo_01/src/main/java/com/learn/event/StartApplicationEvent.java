package com.learn.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description 启动容器发布事件
 * @Author yangxh8
 * @Date 2023/4/5 14:49
 */
public class StartApplicationEvent {
    private static final Logger log = LoggerFactory.getLogger(StartApplicationEvent.class);

    public static void main(String[] args) {
        //注解方式启动spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StartApplicationEvent.class);
        //配置类
        context.register(YootkEventConfig.class);
        //容器刷新
        context.refresh();
        //设置事件类
        YootkEvent yangxh = new YootkEvent("Yangxh");
        //发布事件
        context.publishEvent(yangxh);
    }
}
