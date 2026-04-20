package com.sanwei.system.api.oauth2;

import cn.hutool.core.bean.BeanUtil;
import com.sanwei.framework.common.biz.system.oauth2.OAuth2TokenCommonApi;
import com.sanwei.framework.common.biz.system.oauth2.dto.OAuth2AccessTokenCheckRespDTO;
import com.sanwei.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import com.sanwei.system.service.oauth2.OAuth2TokenService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * OAuth2TokenApiImpl
 *
 * @author caiyang
 * @date 2026/4/17
 */
@Service
public class OAuth2TokenApiImpl implements OAuth2TokenCommonApi {

    @Resource
    private OAuth2TokenService oAuth2TokenService;

    @Override
    public OAuth2AccessTokenCheckRespDTO checkAccessToken(String accessToken) {
        OAuth2AccessTokenDO accessTokenDO = oAuth2TokenService.checkAccessToken(accessToken);
        return BeanUtil.toBean(accessTokenDO, OAuth2AccessTokenCheckRespDTO.class);
    }
}
