package com.sanwei.framework.common.pojo;

import com.sanwei.framework.common.exception.ErrorCode;
import com.sanwei.framework.common.exception.enums.GlobalErrorCodeConstants;
import lombok.Data;

import java.io.Serializable;

/**
 * CommonResult
 * 通用返回
 * @author caiyang
 * @date 2026/4/14
 */
@Data
public class CommonResult<T> implements Serializable {

    /**
     * 错误码 0-成功
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 成功
     * @param data
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>();
        result.code = GlobalErrorCodeConstants.SUCCESS.getCode();
        result.msg = GlobalErrorCodeConstants.SUCCESS.getMsg();
        result.data = data;
        return result;
    }

    /**
     * 失败
     * @param code
     * @param message
     * @return
     * @param <T>
     */
    public static <T> CommonResult<T> error(Integer code, String message) {
        CommonResult<T> result = new CommonResult<>();
        result.code = code;
        result.msg = message;
        return result;
    }

    public static <T> CommonResult<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }
}
