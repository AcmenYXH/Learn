package com.learn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

@SpringBootTest
class Springboot16RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void set() {
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("a", 100);
    }

    @Test
    void get() {
        ValueOperations ops = redisTemplate.opsForValue();
        Object a = ops.get("b");
        System.out.println("结果="+a);
    }

    @Test
    void hset() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("info", "a", "aa");
    }

    @Test
    void hget() {
        HashOperations ops = redisTemplate.opsForHash();
        Object a = ops.get("info", "a");
        System.out.println("结果="+a);
    }
}
