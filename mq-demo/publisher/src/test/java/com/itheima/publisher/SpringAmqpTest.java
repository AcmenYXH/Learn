package com.itheima.publisher;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class SpringAmqpTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void testSendMessage2Queue() {
        String queueName = "simple.queue";
        String msg = "hello, amqp22222!";
        rabbitTemplate.convertAndSend(queueName, msg);
    }

    @Test
    void testWorkQueue() throws InterruptedException {
        String queueName = "work.queue";
        for (int i = 1; i <= 50; i++) {
            String msg = "hello, worker, message_" + i;
            rabbitTemplate.convertAndSend(queueName, msg);
            Thread.sleep(20);
        }
    }

    @Test
    void testSendFanout() {
        String exchangeName = "hmall.fanout";
        String msg = "hello, everyone!";
        rabbitTemplate.convertAndSend(exchangeName, null, msg);
    }

    @Test
    void testSendDirect() {
        String exchangeName = "hmall.direct";
        String msg = "红色通知，警报解除，哥斯拉是放的气球";
        rabbitTemplate.convertAndSend(exchangeName, "red", msg);
    }

    @Test
    void testSendTopic() {
        String exchangeName = "hmall.topic";
        String msg = "中国，每天新鲜事";
        rabbitTemplate.convertAndSend(exchangeName, "china.news", msg);
    }

    @Test
    void testSendObject() {
        // 创建一个Map，用于存储消息
        Map<String, Object> msg = new HashMap<>(2);
        // 向Map中添加name和age键值对
        msg.put("name", "jack");
        msg.put("age", 21);
        // 发送消息到名为object.queue的队列
        rabbitTemplate.convertAndSend("object.queue", msg);
    }
}
