package com.sanwei.system.controller.auth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * AuthLoginRespVO
 *
 * @author caiyang
 * @date 2026/4/16
 */
@Schema(description = "后台管理-登录返回 Response VO")
@Data
public class AuthLoginRespVO {

    @Schema(description = "用户编号", example = "1024")
    private Long userId;

    @Schema(description = "访问令牌", example = "access")
    private String accessToken;

    @Schema(description = "刷新令牌", example = "refresh")
    private String refreshToken;

    @Schema(description = "过期时间", example = "1949-10-1 15:00:00")
    private LocalDateTime expiresTime;
}
