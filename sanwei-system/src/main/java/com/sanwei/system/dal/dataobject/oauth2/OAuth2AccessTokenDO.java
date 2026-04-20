package com.sanwei.system.dal.dataobject.oauth2;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler;
import com.sanwei.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * OAuth2AccessTokenDO
 *
 * @author caiyang
 * @date 2026/4/17
 */
@TableName(value = "system_oauth2_access_token", autoResultMap = true)
@Data
@EqualsAndHashCode(callSuper = false)
public class OAuth2AccessTokenDO extends BaseDO {

    /**
     * 编号，数据库自增
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 访问令牌
     */
    private String accessToken;
    /**
     * 刷新令牌
     */
    private String refreshToken;
    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 用户类型
     */
    private Integer userType;
    /**
     * 用户信息
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private Map<String, String> userInfo;
    /**
     * 客户端编号
     */
    private String clientId;
    /**
     * 授权范围
     */
    @TableField(typeHandler = JacksonTypeHandler.class)
    private List<String> scopes;
    /**
     * 过期时间
     */
    private LocalDateTime expiresTime;
}
