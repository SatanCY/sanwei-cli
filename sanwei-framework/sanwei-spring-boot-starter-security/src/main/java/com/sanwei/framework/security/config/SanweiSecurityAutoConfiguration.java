package com.sanwei.framework.security.config;

import com.sanwei.framework.common.biz.system.oauth2.OAuth2TokenCommonApi;
import com.sanwei.framework.security.core.filter.TokenAuthenticationFilter;
import com.sanwei.framework.security.core.handler.AccessDeniedHandlerImpl;
import com.sanwei.framework.security.core.handler.AuthenticationEntryPointImpl;
import com.sanwei.framework.web.core.GlobalExceptionHandler;
import jakarta.annotation.Resource;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * SanweiSecurityAutoConfiguration
 * Spring Security 自动配置类，主要用于相关组件的配置
 * @author caiyang
 * @date 2026/4/16
 */
@AutoConfiguration
@EnableConfigurationProperties(SecurityProperties.class)
public class SanweiSecurityAutoConfiguration {

    @Resource
    private SecurityProperties securityProperties;

    @Bean
    public AuthenticationEntryPoint authenticationEntryPoint() {
        return new AuthenticationEntryPointImpl();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new AccessDeniedHandlerImpl();
    }

    /**
     * Token 认证过滤器 Bean
     */
    @Bean
    public TokenAuthenticationFilter tokenAuthenticationFilter(GlobalExceptionHandler globalExceptionHandler, OAuth2TokenCommonApi oAuth2TokenCommonApi) {
        return new TokenAuthenticationFilter(securityProperties, globalExceptionHandler, oAuth2TokenCommonApi);
    }
}
