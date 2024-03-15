package com.learn;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description
 * @Author yangxh8
 * @Date 2023/2/21 19:58
 */
public class TaskTest {
    public static void main(String[] args) {
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Timer Task run........");
            }
        };
        timer.schedule(task, 0, 2000);
    }
}
