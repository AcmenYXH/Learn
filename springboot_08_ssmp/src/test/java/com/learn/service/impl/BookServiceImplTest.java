package com.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.learn.service.IBookService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description
 * @Author yangxh8
 * @Date 2022/11/2 21:33
 */
@SpringBootTest
class BookServiceImplTest {
    private static final Logger LOG = LoggerFactory.getLogger(BookServiceImpl2Test.class);

    @Autowired
    private IBookService iBookService;

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void getById() {
        System.out.println("结果="+iBookService.getById(1));
    }

    @Test
    void getAll() {
    }
}