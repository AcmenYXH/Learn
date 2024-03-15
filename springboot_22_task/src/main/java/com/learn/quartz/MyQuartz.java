package com.learn.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Description 定时任务工作quartz
 * @Author yangxh8
 * @Date 2023/2/21 20:11
 */
public class MyQuartz extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("定时任务工作quartz");
    }
}
