package com.learn.controller;

import com.learn.domain.BaseResponse;
import com.learn.service.BookService;
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
    @Autowired
    private BookService bookService;

    @GetMapping("{id}")
    public BaseResponse getBook(@PathVariable Integer id) throws Exception {
        return new BaseResponse(true, bookService.getById(id));
    }

//    @PostMapping
//    public BaseResponse saveBook(@RequestBody Book book) {
//        return new BaseResponse(true, bookService.save(book));
//    }
//
//    @PutMapping
//    public BaseResponse updateBook(@RequestBody Book book) {
//        return new BaseResponse(true, bookService.updateById(book));
//    }
//
//    @DeleteMapping("{id}")
//    public BaseResponse deleteBook(@PathVariable Integer id) {
//        return new BaseResponse(true, new BaseResponse(true, bookService.getById(id)));
//    }
//
//    @GetMapping
//    public BaseResponse getAll() {
//        return new BaseResponse(true, bookService.list());
//    }
//
//    @GetMapping("{current}/{pageSize}")
//    public BaseResponse getPage(@PathVariable Integer current, @PathVariable Integer pageSize) {
//        return new BaseResponse(true, bookService.getPage(current, pageSize));
//    }
}
