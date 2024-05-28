package com.yangxh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 人
 * @Author yangxh8
 * @Date 2024/5/27 22:34
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private String name;
    private int age;
    private int height;
}
