package com.learn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.learn.domain.Book;
import org.apache.ibatis.annotations.Param;

/**
 * @Description MP实现业务层
 * @Author yangxh8
 * @Date 2022/11/2 21:21
 */
public interface IBookService extends IService<Book> {
    IPage<Book> getPage(Integer current, Integer pageSize);

    /**
     * 自定义的sql的分页查询
     * @param page
     * @param book
     * @return
     * @throws Exception
     */
    IPage<Book> selfDefinedSearch(@Param("page") IPage<Book> page, @Param("book") Book book) throws Exception;
}
