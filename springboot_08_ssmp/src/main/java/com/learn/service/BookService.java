package com.learn.service;

import com.learn.domain.Book;

import java.util.List;

/**
 * @Description
 * @Author yangxh8
 * @Date 2022/11/2 20:59
 */
public interface BookService {
    Boolean save(Book book);
    Boolean update(Book book);
    Boolean delete(Integer id);
    Book getById(Integer id);
    List<Book> getAll();
}
