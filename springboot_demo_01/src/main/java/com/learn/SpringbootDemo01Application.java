package com.learn;

import com.learn.event.YootkEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@EnableAsync
@SpringBootApplication
public class SpringbootDemo01Application {
    private static final Logger log = LoggerFactory.getLogger(SpringbootDemo01Application.class);

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(SpringbootDemo01Application.class, args);
        YootkEvent yangxh = new YootkEvent("Yangxh");
        run.publishEvent(yangxh);
        if (log.isInfoEnabled()) {
            log.info("事件发布成功");
        }
    }

}
