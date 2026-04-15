package com.sanwei.framework.web.core;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.sanwei.framework.common.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.sanwei.framework.common.pojo.CommonResult;

import java.util.List;

import static com.sanwei.framework.common.exception.enums.GlobalErrorCodeConstants.*;

/**
 * GlobalExceptionHandler
 *
 * @author caiyang
 * @date 2026/4/14
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理 SpringMVC 参数校验错误
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<?> methodArgumentNotValidExceptionExceptionHandler(MethodArgumentNotValidException exception) {
        log.warn("[methodArgumentNotValidExceptionExceptionHandler]", exception);
        // 获取 errorMessage
        String errorMessage = null;
        FieldError fieldError = exception.getBindingResult().getFieldError();
        if (fieldError == null) {
            List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
            if (CollUtil.isNotEmpty(allErrors)) {
                errorMessage = allErrors.get(0).getDefaultMessage();
            }
        } else {
            errorMessage = fieldError.getDefaultMessage();
        }
        // 转换成 CommonResult
        if (StrUtil.isEmpty(errorMessage)) {
            return CommonResult.error(BAD_REQUEST);
        }
        return CommonResult.error(BAD_REQUEST.getCode(), String.format("请求参数不正确:%s", errorMessage));
    }

    /**
     * 处理业务异常 ServiceException
     */
    @ExceptionHandler(value = ServiceException.class)
    public CommonResult<?> serviceExceptionHandler(ServiceException exception) {
        log.warn("[serviceExceptionHandler]", exception);
        return CommonResult.error(exception.getCode(), exception.getMessage());
    }

    /**
     * 处理系统异常，兜底处理所有的异常
     */
    @ExceptionHandler(value = Exception.class)
    public CommonResult<?> defaultExceptionHandler(HttpServletRequest request, Throwable exception) {
        // 特殊情况，ServiceException 异常，直接返回
        if (exception.getCause() != null && exception.getCause() instanceof ServiceException) {
            return serviceExceptionHandler((ServiceException) exception);
        }

        // 处理异常
        log.error("[defaultExceptionHandler]", exception);
        return CommonResult.error(INTERNAL_SERVER_ERROR.getCode(), INTERNAL_SERVER_ERROR.getMsg());
    }
}
