package com.sanwei.system.service.auth;

import com.sanwei.system.controller.auth.vo.AuthLoginRespVO;
import com.sanwei.system.controller.auth.vo.AuthRegisterReqVO;
import com.sanwei.system.service.user.UserServiceImpl;
import org.springframework.stereotype.Service;

/**
 * AuthServiceImpl
 *
 * @author caiyang
 * @date 2026/4/20
 */
@Service
public class AuthServiceImpl implements AuthService {
    private final UserServiceImpl userService;

    public AuthServiceImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public AuthLoginRespVO register(AuthRegisterReqVO registerReqVO) {
        // todo 1.校验验证码

        // 2.校验用户是否已存在
        Long userId = userService.registerUser(registerReqVO);
        return null;
    }
}
