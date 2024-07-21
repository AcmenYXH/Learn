package com.yangxh.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description ${description}
 * @Author yangxh8
 * @Date 2024/6/19 22:08
 */
@SpringBootApplication
@MapperScan("com.yangxh.cloud.mapper") //import tk.mybatis.spring.annotation.MapperScan;
@EnableDiscoveryClient //该注解用于向使用consul为注册中心时注册服务
@RefreshScope // Consul的动态刷新配置
public class Main8002 {
    public static void main(String[] args) {
        SpringApplication.run(Main8002.class, args);
    }
}