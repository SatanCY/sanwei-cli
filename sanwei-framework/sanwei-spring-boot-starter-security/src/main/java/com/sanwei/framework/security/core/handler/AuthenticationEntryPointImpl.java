package com.sanwei.framework.security.core.handler;

import com.sanwei.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.sanwei.framework.common.pojo.CommonResult;
import com.sanwei.framework.common.util.servlet.ServletUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

import static com.sanwei.framework.common.exception.enums.GlobalErrorCodeConstants.UNAUTHORIZED;

/**
 * AuthenticationEntryPointImpl
 * 访问一个需要认证的 URL 资源，但是此时自己尚未认证（登录）的情况下，返回 {@link GlobalErrorCodeConstants#UNAUTHORIZED} 错误码，从而使前端重定向到登录页
 * @author caiyang
 * @date 2026/4/17
 */
@Slf4j
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        log.debug("[commence][访问 URL({}) 时，没有登录]", request.getRequestURI(), authException);
        // 返回 401
        ServletUtils.writeJSON(response, CommonResult.error(UNAUTHORIZED));
    }
}
