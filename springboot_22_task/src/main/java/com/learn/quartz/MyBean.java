package com.learn.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author yangxh8
 * @Date 2023/2/22 20:28
 */
@Component
public class MyBean {
    @Scheduled(cron = "0/1 * * * * ?")
    public void run() {
        System.out.println("线程【" + Thread.currentThread().getName() + "】=spring task run......");
    }
}
