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

}
