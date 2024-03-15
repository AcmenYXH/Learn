package com.learn.dao;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Description
 * @Author yangxh8
 * @Date 2022/9/18 12:28
 */
@SpringBootTest
class BookDaoTest {
    private static final Logger LOG = LoggerFactory.getLogger(BookDaoTest.class);

    @Autowired
    private BookDao bookDao;


    @Test
    void deleteByPrimaryKey() {
    }

    @Test
    void insert() {
    }

    @Test
    void insertSelective() {
    }

    @Test
    void selectByPrimaryKey() {
//        Book book = bookDao.selectById(1);
        List<Book> books = bookDao.selectList(null);
        if (LOG.isInfoEnabled()) {
            LOG.info("结果={}", JSON.toJSONString(books, true));
        }
    }

    @Test
    void updateByPrimaryKeySelective() {
    }

    @Test
    void updateByPrimaryKey() {
    }
}