package com.learn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

/**
 * @Description
 * @Author yangxh8
 * @Date 2023/2/10 20:23
 */
@SpringBootTest
public class StringTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void get() {
        ValueOperations ops = stringRedisTemplate.opsForValue();
        Object b = ops.get("b");
        System.out.println("结果="+b);
    }

}
