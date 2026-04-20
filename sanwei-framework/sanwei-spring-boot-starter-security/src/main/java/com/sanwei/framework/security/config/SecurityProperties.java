package com.sanwei.framework.security.config;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.util.Collections;
import java.util.List;

/**
 * SecurityProperties
 * Security 自定义配置属性类
 * @author caiyang
 * @date 2026/4/17
 */
@ConfigurationProperties(prefix = "sanwei.security")
@Data
@Validated
public class SecurityProperties {

    /**
     * HTTP 请求中，访问令牌的请求 Header
     */
    @NotEmpty(message = "Token Header 不能为空")
    private String tokenHeader = "Authorization";

    /**
     * HTTP 请求中，访问令牌的请求参数
     */
    @NotEmpty(message = "Token Parameter 不能为空")
    private String tokenParameter = "token";

    /**
     * mock 模式的开关
     */
    @NotNull(message = "mock 模式的开关不能为空")
    private Boolean mockEnable = false;
    /**
     * mock 模式的密钥
     * 一定要配置密钥，保证安全性
     */
    @NotEmpty(message = "mock 模式的密钥不能为空") // 这里设置了一个默认值，因为实际上只有 mockEnable 为 true 时才需要配置。
    private String mockSecret = "test-security";

    /**
     * 免登录的 URL 列表
     */
    private List<String> permitAllUrls = Collections.emptyList();

    /**
     * PasswordEncoder 加密复杂度，越大，开销越大
     */
    private Integer passwordEncoderLength = 4;
}
