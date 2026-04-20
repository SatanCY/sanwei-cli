package com.sanwei.framework.security.core.handler;

import com.sanwei.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.sanwei.framework.common.pojo.CommonResult;
import com.sanwei.framework.common.util.servlet.ServletUtils;
import com.sanwei.framework.security.core.util.SecurityFrameworkUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

import static com.sanwei.framework.common.exception.enums.GlobalErrorCodeConstants.FORBIDDEN;

/**
 * AccessDeniedHandlerImpl
 * 访问一个需要认证的 URL 资源，已经认证（登录）但是没有权限的情况下，返回 {@link GlobalErrorCodeConstants#FORBIDDEN} 错误码。
 * @author caiyang
 * @date 2026/4/17
 */
@Slf4j
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.warn("[commence][访问 URL({}) 时，用户({}) 权限不够]", request.getRequestURI(), SecurityFrameworkUtils.getLoginUserId(), accessDeniedException);
        ServletUtils.writeJSON(response, CommonResult.error(FORBIDDEN));
    }
}
