package com.sanwei.system.dal.mysql.oauth2;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sanwei.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * OAuth2AccessTokenMapper
 *
 * @author caiyang
 * @date 2026/4/17
 */
@Mapper
public interface OAuth2AccessTokenMapper extends BaseMapper<OAuth2AccessTokenDO> {

    default OAuth2AccessTokenDO selectByAccessToken(String accessToken) {
        LambdaQueryWrapper<OAuth2AccessTokenDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(OAuth2AccessTokenDO::getAccessToken, accessToken);
        return selectOne(queryWrapper);
    };
}
