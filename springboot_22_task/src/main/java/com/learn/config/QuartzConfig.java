package com.learn.config;

import com.learn.quartz.MyQuartz;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 定时任务Quartz配置
 * @Author yangxh8
 * @Date 2023/2/21 20:20
 */
@Configuration
public class QuartzConfig {
    @Bean
    public JobDetail printJobDetail() {
        //绑定具体的工作
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    public Trigger printTrigger() {
        ScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //绑定对应的工作明细
        return TriggerBuilder.newTrigger().forJob(printJobDetail()).withSchedule(scheduleBuilder).build();
    }

}
