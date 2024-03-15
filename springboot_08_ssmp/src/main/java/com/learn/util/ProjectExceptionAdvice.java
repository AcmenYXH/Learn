package com.learn.util;

import com.learn.domain.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Description 统一异常处理
 * @Author yangxh8
 * @Date 2022/11/6 20:43
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    private static final Logger LOG = LoggerFactory.getLogger(ProjectExceptionAdvice.class);

    @ExceptionHandler(Exception.class)
    public BaseResponse doException(Exception e) {
        //记录异常信息
        //通知运维
        LOG.error("Util--统一异常处理=", e);
        return new BaseResponse("系统异常，请联系管理员！");
    }
}
