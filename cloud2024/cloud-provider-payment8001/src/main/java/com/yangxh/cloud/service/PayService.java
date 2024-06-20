package com.yangxh.cloud.service;

import com.yangxh.cloud.entities.Pay;

import java.util.List;

/**
 * @Description 服务层
 * @Author yangxh8
 * @Date 2024/6/20 22:21
 */
public interface PayService {
    int add(Pay pay);
    int delete(Integer id);
    int update(Pay pay);
    Pay getById(Integer id);
    List<Pay> getAll();
}
