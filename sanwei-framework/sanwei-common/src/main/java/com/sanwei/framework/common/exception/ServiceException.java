package com.sanwei.framework.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * ServiceException
 *
 * @author caiyang
 * @date 2026/4/14
 */
@Data
@EqualsAndHashCode(callSuper = true)
public final class ServiceException extends RuntimeException {

    /**
     * 业务错误码
     */
    private Integer code;

    /**
     * 错误提示
     */
    private String message;

    public ServiceException() {}

    public ServiceException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public ServiceException setCode(Integer code) {
        this.code = code;
        return this;
    }

    public ServiceException setMessage(String message) {
        this.message = message;
        return this;
    }
}
