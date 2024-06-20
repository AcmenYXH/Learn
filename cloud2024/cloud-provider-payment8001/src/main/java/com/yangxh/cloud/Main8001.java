package com.yangxh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description ${description}
 * @Author yangxh8
 * @Date 2024/6/19 22:08
 */
@SpringBootApplication
@MapperScan("com.yangxh.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class, args);
    }
}