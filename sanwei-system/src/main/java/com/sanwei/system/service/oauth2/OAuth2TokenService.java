package com.sanwei.system.service.oauth2;

import com.sanwei.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;

/**
 * OAuth2TokenService
 *
 * @author caiyang
 * @date 2026/4/17
 */
public interface OAuth2TokenService {

    /**
     * 获取访问令牌
     * @param accessToken 访问令牌
     * @return 访问令牌信息
     */
    OAuth2AccessTokenDO getAccessToken(String accessToken);

    /**
     * 校验访问令牌
     * @param accessToken 访问令牌
     * @return 访问令牌信息
     */
    OAuth2AccessTokenDO checkAccessToken(String accessToken);
}
