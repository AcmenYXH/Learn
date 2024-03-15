package com.learn.service.impl;

import com.learn.domain.Book;
import com.learn.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author yangxh8
 * @Date 2022/11/2 21:01
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

//    @Autowired
//    private BookDao bookDao;
//
//    @Override
//    public Boolean save(Book book) {
//        return bookDao.insert(book) > 0;
//    }
//
//    @Override
//    public Boolean update(Book book) {
//        return bookDao.updateById(book) > 0;
//    }
//
//    @Override
//    public Boolean delete(Integer id) {
//        return bookDao.deleteById(id) > 0;
//    }

    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book getById(Integer id) {
        Book book = new Book(1L,"cache", "cache",  "cache");
        if (log.isInfoEnabled()) {
            log.info("查询结果={}", book);
        }
        return book;
    }

//    @Override
//    public List<Book> getAll() {
//        return bookDao.selectList(null);
//    }
}
