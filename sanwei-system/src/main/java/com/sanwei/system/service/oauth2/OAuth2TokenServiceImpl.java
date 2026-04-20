package com.sanwei.system.service.oauth2;

import com.sanwei.framework.common.exception.ServiceException;
import com.sanwei.framework.common.exception.enums.GlobalErrorCodeConstants;
import com.sanwei.framework.common.util.date.DateUtils;
import com.sanwei.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import com.sanwei.system.dal.mysql.oauth2.OAuth2AccessTokenMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * OAuth2TokenServiceImpl
 *
 * @author caiyang
 * @date 2026/4/17
 */
@Service
public class OAuth2TokenServiceImpl implements OAuth2TokenService{

    @Resource
    private OAuth2AccessTokenMapper oAuth2AccessTokenMapper;

    @Override
    public OAuth2AccessTokenDO getAccessToken(String accessToken) {
        // todo 从redis中获取访问令牌
        // 获取不到，从 MySQL 数据库中获取访问令牌
        return oAuth2AccessTokenMapper.selectByAccessToken(accessToken);
    }

    @Override
    public OAuth2AccessTokenDO checkAccessToken(String accessToken) {
        OAuth2AccessTokenDO accessTokenDO = getAccessToken(accessToken);
        if (accessTokenDO == null) {
            throw new ServiceException(GlobalErrorCodeConstants.UNAUTHORIZED.getCode(), "访问令牌不存在");
        }
        if (DateUtils.isExpired(accessTokenDO.getExpiresTime())) {
            throw new ServiceException(GlobalErrorCodeConstants.UNAUTHORIZED.getCode(), "访问令牌已过期");
        }
        return accessTokenDO;
    }
}
