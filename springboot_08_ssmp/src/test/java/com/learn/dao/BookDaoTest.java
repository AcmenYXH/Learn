package com.learn.dao;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Description
 * @Author yangxh8
 * @Date 2022/11/1 21:27
 */
@SpringBootTest
class BookDaoTest {
    private static final Logger LOG = LoggerFactory.getLogger(BookDaoTest.class);

    @Autowired
    private BookDao bookDao;

    @Test
    void testSelectById() {
        bookDao.selectById(1);
    }

    @Test
    void testInsert() {
        for (int i = 0, len = 5; i < len; i++) {
            Book book = new Book();
            book.setType("测试"+i*10);
            book.setName("测试"+i*10);
            book.setDescription("测试"+i*10);
            bookDao.insert(book);
        }
    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(5L);
        book.setType("测试3");
        book.setName("测试3");
        book.setDescription("测试3");
        bookDao.updateById(book);
    }

    @Test
    void testDelete() {
        bookDao.deleteById(5L);
    }

    @Test
    void testGetAll() {
        bookDao.selectList(null);
    }

    @Test
    void testGetPage() {
        IPage page = new Page(2, 2);
        bookDao.selectPage(page, null);
        System.out.println(JSONObject.toJSONString(page));
    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "三体");
        List<Book> books = bookDao.selectList(queryWrapper);
        if (LOG.isDebugEnabled()) {
            LOG.debug("结果={}", JSONObject.toJSONString(books));
        }
    }

    @Test
    void testGetBy2() {
        String name = null;
        LambdaQueryWrapper<Book> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Strings.isNotBlank(name), Book::getName, name);
        //==>  Preparing: SELECT id,name,type,description FROM tb_book WHERE (name LIKE ?)
        //==> Parameters: %null%(String)
        //所以查询字段要判断不位空
        List<Book> books = bookDao.selectList(queryWrapper);
        if (LOG.isDebugEnabled()) {
            LOG.debug("结果={}", JSONObject.toJSONString(books));
        }
    }
}