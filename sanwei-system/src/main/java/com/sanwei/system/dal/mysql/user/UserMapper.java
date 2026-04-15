package com.sanwei.system.dal.mysql.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sanwei.system.dal.dataobject.user.UserDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * UserMapper
 *
 * @author caiyang
 * @date 2026/4/15
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
