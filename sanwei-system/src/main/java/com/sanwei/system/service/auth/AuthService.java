package com.sanwei.system.service.auth;

import com.sanwei.system.controller.auth.vo.AuthLoginRespVO;
import com.sanwei.system.controller.auth.vo.AuthRegisterReqVO;

/**
 * AuthService
 *
 * @author caiyang
 * @date 2026/4/20
 */
public interface AuthService {

    /**
     * 用户注册
     * @param registerReqVO 注册用户
     * @return 注册结果
     */
    AuthLoginRespVO register(AuthRegisterReqVO registerReqVO);
}
