package com.sanwei.system.controller.auth;

import com.sanwei.framework.common.pojo.CommonResult;
import com.sanwei.system.controller.auth.vo.AuthLoginReqVO;
import com.sanwei.system.controller.auth.vo.AuthLoginRespVO;
import com.sanwei.system.controller.auth.vo.AuthRegisterReqVO;
import com.sanwei.system.service.auth.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.sanwei.framework.common.pojo.CommonResult.success;

/**
 * AuthController
 *
 * @author caiyang
 * @date 2026/4/16
 */
@Tag(name = "后台管理-权限模块")
@RestController
@RequestMapping("/system/auth")
@Validated
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "使用账号密码登录")
    @PermitAll
    public CommonResult<AuthLoginRespVO> login(@Valid @RequestBody AuthLoginReqVO reqVO) {
        AuthLoginRespVO result = new AuthLoginRespVO();
        result.setAccessToken("test-token 1s5ds1d455fsd1fdsf4s5d1");
        return success(result);
    }

    @PostMapping("/logout")
    @Operation(summary = "登出系统")
    public CommonResult<Boolean> logout(HttpServletRequest request) {
        if ("test-token 1s5ds1d455fsd1fdsf4s5d1".equals(request.getHeader("Authorization"))) {
            return success(true);
        }
        return CommonResult.error(400, "登出失败");
    }

    @PostMapping("/register")
    @Operation(summary = "注册用户")
    @PermitAll
    public CommonResult<AuthLoginRespVO> register(@RequestBody @Valid AuthRegisterReqVO registerReqVO) {
        return success(authService.register(registerReqVO));
    }
}
