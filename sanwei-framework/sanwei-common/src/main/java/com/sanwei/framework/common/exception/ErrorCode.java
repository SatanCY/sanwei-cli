package com.sanwei.framework.common.exception;

import lombok.Data;

/**
 * ErrorCode
 * 错误码对象
 * @author caiyang
 * @date 2026/4/14
 */
@Data
public class ErrorCode {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
