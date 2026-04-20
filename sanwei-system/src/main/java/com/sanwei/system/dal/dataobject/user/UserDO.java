package com.sanwei.system.dal.dataobject.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sanwei.framework.mybatis.core.dataobject.BaseDO;
import lombok.*;

/**
 * UserDO
 * 用户DO
 * @author caiyang
 * @date 2026/4/15
 */
@TableName(value = "system_users", autoResultMap = true)
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDO extends BaseDO {

    /**
     * 用户ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 用户账号
     */
    private String username;
    /**
     * 用户密码（加密）
     */
    private String password;
    /**
     * 用户昵称
     */
    private String nickname;
}
