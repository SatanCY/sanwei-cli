package com.sanwei.system.controller.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * UserSaveReq
 *
 * @author caiyang
 * @date 2026/4/16
 */
@Schema(description = "后台管理-用户创建/修改 Request VO")
@Data
public class UserSaveReqVO {

    @Schema(description = "用户编号", example = "1024")
    private Long id;

    @Schema(description = "用户账号", example = "sanwei")
    @Size(min = 4, max = 30, message = "用户账号长度为 4-30 个字符")
    private String username;

    @Schema(description = "密码", example = "123456")
    @Size(min = 3, max = 16, message = "密码长度为 3-16 位")
    private String password;

    @Schema(description = "用户昵称", example = "三味")
    @Size(max = 30, message = "用户昵称最大为 30 个字符")
    private String nickname;
}
