package com.learn.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.learn.dao.BookDao;
import com.learn.domain.Book;
import com.learn.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description MP实现业务层方法
 * @Author yangxh8
 * @Date 2022/11/2 21:30
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    public BookDao bookDao;

    @Override
    public IPage<Book> getPage(Integer current, Integer pageSize) {
        IPage page = new Page(current, pageSize);
        bookDao.selectPage(page, null);
        return page;
    }

    @Override
    public IPage<Book> selfDefinedSearch(IPage<Book> page, Book book) throws Exception {
        return bookDao.selfDefinedSearch(page, null);
    }
}
