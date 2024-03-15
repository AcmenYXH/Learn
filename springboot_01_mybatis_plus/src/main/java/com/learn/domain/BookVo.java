package com.learn.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 书
 * @Author yangxh8 
 * @Date 2022-09-18 
 */
@Data
public class BookVo implements Serializable {

	private static final long serialVersionUID =  7176118380869401403L;

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
