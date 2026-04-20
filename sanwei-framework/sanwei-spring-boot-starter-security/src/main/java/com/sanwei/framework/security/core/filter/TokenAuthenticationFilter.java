package com.sanwei.framework.security.core.filter;

import cn.hutool.core.util.StrUtil;
import com.sanwei.framework.common.biz.system.oauth2.OAuth2TokenCommonApi;
import com.sanwei.framework.common.biz.system.oauth2.dto.OAuth2AccessTokenCheckRespDTO;
import com.sanwei.framework.common.exception.ServiceException;
import com.sanwei.framework.security.config.SecurityProperties;
import com.sanwei.framework.security.core.LoginUser;
import com.sanwei.framework.security.core.util.SecurityFrameworkUtils;
import com.sanwei.framework.web.core.GlobalExceptionHandler;
import com.sanwei.framework.web.core.util.WebFrameworkUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * TokenAuthenticationFilter
 *
 * @author caiyang
 * @date 2026/4/17
 */
@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final SecurityProperties securityProperties;

    private final GlobalExceptionHandler globalExceptionHandler;

    private final OAuth2TokenCommonApi oAuth2TokenCommonApi;

    @Override
    @SuppressWarnings("NullableProblems") // 抑制 IDE 对方法参数可空性的警告
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = SecurityFrameworkUtils.obtainAuthorization(request, securityProperties.getTokenHeader(), securityProperties.getTokenParameter());
        if (StrUtil.isNotEmpty(token)) {
            // 获取用户类型
            Integer userType = WebFrameworkUtils.getLoginUserType(request);
            // 基于 Token 构建登录用户
            LoginUser loginUser = buildLoginUserByToken(token, userType);
            // 模拟 Login 功能，方便日常开发调试
            if (loginUser == null) {
                loginUser = mockLoginUser(request, token, userType);
            }
            // 设置当前用户
            if (loginUser != null) {
                SecurityFrameworkUtils.setLoginUser(loginUser, request);
            }
        }

        filterChain.doFilter(request, response);
    }

    private LoginUser buildLoginUserByToken(String token, Integer userType) {
        try {
            OAuth2AccessTokenCheckRespDTO accessToken = oAuth2TokenCommonApi.checkAccessToken(token);
            if (accessToken == null) {
                return null;
            }
            return new LoginUser().setId(accessToken.getUserId()).setUserType(accessToken.getUserType())
                    .setInfo(accessToken.getUserInfo())
                    .setTenantId(accessToken.getTenantId())
                    .setExpiresTime(accessToken.getExpiresTime());
        } catch (ServiceException serviceException) {
            // 校验 Token 不通过时，考虑到一些接口是无需登录的，所以直接返回 null 即可
            return null;
        }
    }

    /**
     * 模拟登录用户，方便日常开发调试
     *
     * 注意，在线上环境下，一定要关闭该功能！！！
     *
     * @param request 请求
     * @param token 模拟的 token，格式为 {@link SecurityProperties#getMockSecret()} + 用户编号
     * @param userType 用户类型
     * @return 模拟的 LoginUser
     */
    private LoginUser mockLoginUser(HttpServletRequest request, String token, Integer userType) {
        if (!securityProperties.getMockEnable()) {
            return null;
        }
        // 必须以 mockSecret 开头
        if (!token.startsWith(securityProperties.getMockSecret())) {
            return null;
        }
        // 构建模拟用户
        Long userId = Long.valueOf(token.substring(securityProperties.getMockSecret().length()));
        return new LoginUser().setId(userId).setUserType(userType)
                .setTenantId(WebFrameworkUtils.getTenantId(request));
    }
}
