package com.yangxh.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description @Myretry 注解
 * 使其标注在方法上。
 * 1. 能够根据注解的参数 max_count，最大重试次数
 * 2. 能够根据注解参数 forExection，捕获指定的异常去进行重试
 * 3. 能够根据注解参数 forRollback，当重试次数达到最大时， 还是失败执行指定的回退方法进行回退
 * @Author yangxh8
 * @Date 2024/5/8 10:32
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyRetry {
    /**
     * 最大重试次数,默认为3次
     * @return
     */
    int max_retry_count() default 3;

    /**
     * 捕获指定的异常去进行重试
     * @return
     */
    Class<? extends Exception>[] forExection() default {};

    /**
     * 重试次数达到最大时， 还是失败执行指定的回退方法进行回退
     * @return
     */
    String forRollback() default "";
}
