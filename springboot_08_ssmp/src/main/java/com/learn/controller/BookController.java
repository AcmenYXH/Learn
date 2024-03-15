package com.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.learn.domain.BaseResponse;
import com.learn.domain.Book;
import com.learn.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author yangxh8
 * @Date 2022/11/6 16:00
 */
@RestController
@RequestMapping(value = "/books")
public class BookController {
    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    private IBookService bookService;

    @GetMapping("{id}")
    public BaseResponse getBook(@PathVariable Integer id) throws Exception {
        if (id == 1) {
            throw new Exception("测试异常场景！");
        }
        return new BaseResponse(true, bookService.getById(id));
    }

    @PostMapping
    public BaseResponse saveBook(@RequestBody Book book) {
        return new BaseResponse(true, bookService.save(book));
    }

    @PutMapping
    public BaseResponse updateBook(@RequestBody Book book) {
        return new BaseResponse(true, bookService.updateById(book));
    }

    @DeleteMapping("{id}")
    public BaseResponse deleteBook(@PathVariable Integer id) {
        return new BaseResponse(true, new BaseResponse(true, bookService.getById(id)));
    }

    @GetMapping
    public BaseResponse getAll() {
        return new BaseResponse(true, bookService.list());
    }

    /**
     * 多条件查询
     * @param book
     * @return
     */
    @PostMapping(value = "/getBookBycondition")
    public BaseResponse getAll(@RequestBody Book book) {
        log.info("Ctrl--多条件查询--request={}", JSONObject.toJSONString(book));
//        QueryWrapper<Book> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("name", book.getName());
//        queryWrapper.likeRight("type", book.getType());
        LambdaQueryWrapper<Book> lambdaQuery = Wrappers.lambdaQuery(Book.class).like(Book::getName, book.getName()).likeRight(Book::getType, book.getType());
        return new BaseResponse(true, bookService.list(lambdaQuery));
    }

    /**
     * 自定义sql
     * @param book
     * @return
     */
    @PostMapping(value = "/selfDefinedSearch")
    public BaseResponse selfDefinedSearch(@RequestBody Book book) throws Exception {
        IPage<Book> page = new Page<>(1,2);
        page.setCurrent(1);
        page.setSize(2);
        return new BaseResponse(true, bookService.selfDefinedSearch(page, book));
    }

    @GetMapping("{current}/{pageSize}")
    public BaseResponse getPage(@PathVariable Integer current, @PathVariable Integer pageSize) {
        return new BaseResponse(true, bookService.getPage(current, pageSize));
    }
}
