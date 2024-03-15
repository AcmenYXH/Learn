package com.learn.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description 基本响应体
 * @Author yangxh8
 * @Date 2022/11/6 16:48
 */
@Data
public class BaseResponse implements Serializable {
    private static final long serialVersionUID = 6211269385569644092L;
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回数据
     */
    private Object data;
    /**
     * 返回消息
     */
    private String resultMsg;

    public BaseResponse(boolean success) {
        this.success = success;
    }

    public BaseResponse(boolean success, Object data) {
        this.success = success;
        this.data = data;
    }

    public BaseResponse(String resultMsg) {
        this.success = false;
        this.resultMsg = resultMsg;
    }

}
