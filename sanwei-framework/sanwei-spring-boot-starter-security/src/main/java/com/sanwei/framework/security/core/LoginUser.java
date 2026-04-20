package com.sanwei.framework.security.core;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * LoginUser
 *
 * @author caiyang
 * @date 2026/4/17
 */
@Data
public class LoginUser {

    /**
     * 用户编号
     */
    private Long id;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 租户编号
     */
    private Long tenantId;
    /**
     * 附带的用户信息
     */
    private Map<String, String> info;

    /**
     * 过期时间
     */
    private LocalDateTime expiresTime;
}
