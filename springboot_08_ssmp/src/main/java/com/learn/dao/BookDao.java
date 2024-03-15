package com.learn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.learn.domain.Book;
import org.apache.ibatis.annotations.*;


/**
 * @Description
 * @Author yangxh8
 * @Date 2022/11/1 21:25
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

    /**
     * 自定义的sql的分页查询
     * @param page
     * @param book
     * @return
     * @throws Exception
     */
    @Select("select * from tb_book a")
    IPage<Book> selfDefinedSearch(@Param("page") IPage<Book> page, @Param("book") Book book) throws Exception;
}
