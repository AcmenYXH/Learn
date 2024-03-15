package com.learn.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author yangxh8
 * @Date 2022/9/3 11:12
 */
@RestController
@RequestMapping(value = "books")
public class BookController {

    @GetMapping
    public String getById() {
        return "spring boot starting ....";
    }
}
