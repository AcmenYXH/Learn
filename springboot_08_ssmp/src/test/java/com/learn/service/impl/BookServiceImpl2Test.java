package com.learn.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.learn.service.BookService;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author yangxh8
 * @Date 2022/11/2 21:05
 */
@SpringBootTest
@Transactional
@Rollback(true)
class BookServiceImpl2Test {
    private static final Logger LOG = LoggerFactory.getLogger(BookServiceImpl2Test.class);
    
    @Autowired
    private BookService bookService;

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
        if (LOG.isDebugEnabled()) {
            LOG.debug("结果={}", JSONObject.toJSONString(bookService.getById(1)));
        }
        System.out.println("结果="+bookService.getById(1));
    }

    @Test
    void getAll() {
    }
}