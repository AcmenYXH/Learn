package com.yangxh;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CustomAnnotationApplicationTests {
    @Autowired
    SomeService service;

    @Test
    void contextLoads() {
        service.someMethodThatMayFail();
        System.out.println("主线程逻辑");
    }

    @Test
    void simpleCacheTest() throws Exception {
        SimpleCache simpleCache = new SimpleCache(10*1000);
        simpleCache.put("aa", 121211L);
        Thread.sleep(1000);
        System.out.println("获取值："+simpleCache.get("aa"));
        Thread.sleep(10*1000);
        System.out.println("获取值："+simpleCache.get("aa"));
    }

}
