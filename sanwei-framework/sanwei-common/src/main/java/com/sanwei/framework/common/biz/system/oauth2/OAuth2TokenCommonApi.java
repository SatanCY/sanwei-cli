package com.sanwei.framework.common.biz.system.oauth2;

import com.sanwei.framework.common.biz.system.oauth2.dto.OAuth2AccessTokenCheckRespDTO;

/**
 * OAuth2TokenCommonApi
 * OAuth2.0 Token API 接口
 * @author caiyang
 * @date 2026/4/17
 */
public interface OAuth2TokenCommonApi {

    /**
     * 校验访问令牌
     * @param accessToken 访问令牌
     * @return 访问令牌的信息
     */
    OAuth2AccessTokenCheckRespDTO checkAccessToken(String accessToken);
}
