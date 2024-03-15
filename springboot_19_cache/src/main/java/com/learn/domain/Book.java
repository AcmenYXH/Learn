package com.learn.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description 书
 * @Author yangxh8
 * @Date 2022-09-18
 */
@Data
@AllArgsConstructor
public class Book implements Serializable {
    private static final long serialVersionUID = 4441542027103763085L;
    /**
     * 主键
     */
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 描述
     */
    private String description;

}
