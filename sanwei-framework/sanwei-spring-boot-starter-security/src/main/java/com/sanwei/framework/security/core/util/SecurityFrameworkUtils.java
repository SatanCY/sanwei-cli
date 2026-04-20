package com.sanwei.framework.security.core.util;

import cn.hutool.core.util.StrUtil;
import com.sanwei.framework.security.core.LoginUser;
import jakarta.annotation.Nullable;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import java.util.Collections;

/**
 * SecurityFrameworkUtils
 * Security 服务工具类
 * @author caiyang
 * @date 2026/4/17
 */
public class SecurityFrameworkUtils {

    private static final String AUTHORIZATION_BEARER = "Bearer";

    /**
     * 从请求头中获取认证 Token
     * @param request 请求
     * @param headerName 认证 Token 对应的 Header 名称
     * @param parameterName 认证 Token 对应的 Parameter 名称
     * @return 认证 Token
     */
    public static String obtainAuthorization(HttpServletRequest request, String headerName, String parameterName) {
        // 1.获取 Token ,优先级 Header > Parameter
        String token = request.getHeader(headerName);
        if (StrUtil.isEmpty(token)) {
            token = request.getParameter(parameterName);
        }
        if (StrUtil.isBlank(token)) {
            return null;
        }
        // 2.去除 Token 中的 Bearer
        int index = token.indexOf(AUTHORIZATION_BEARER + " ");
        return index >= 0 ? token.substring(index + 7).trim() : token;
    }

    /**
     * 获得当前认证信息
     * @return 认证信息
     */
    public static Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context == null) {
            return null;
        }
        return context.getAuthentication();
    }

    /**
     * 获取当前用户
     * @return 当前用户
     */
    public static LoginUser getLoginUser() {
        Authentication authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }
        return authentication.getPrincipal() instanceof LoginUser ? (LoginUser) authentication.getPrincipal() : null;
    }

    /**
     * 获取当前用户的编号
     * @return 当前用户编号
     */
    @Nullable
    public static Long getLoginUserId() {
        LoginUser loginUser = getLoginUser();
        return loginUser != null ? loginUser.getId() : null;
    }

    public static void setLoginUser(LoginUser loginUser, HttpServletRequest request) {
        // 创建 Authentication，并设置到上下文里
        Authentication authentication = buildAuthentication(loginUser, request);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private static Authentication buildAuthentication(LoginUser loginUser, HttpServletRequest request) {
        // 创建 UsernamePasswordAuthenticationToken 对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser, null, Collections.emptyList());
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        return authenticationToken;
    }
}
