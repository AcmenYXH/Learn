package com.learn.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * book
 * @author 
 */
@Data
@ToString
//当持久化类名和表名不一致时，可以使用@TableName注解指定表名称
@TableName("book")
public class Book implements Serializable {
    /**
     * 主键
     */
    private Integer id;

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

    private static final long serialVersionUID = 1L;
}