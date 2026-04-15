package com.sanwei.system.service.user;

import com.sanwei.system.dal.dataobject.user.UserDO;

import java.util.List;

/**
 * UserService
 * 用户服务接口
 * @author caiyang
 * @date 2026/4/15
 */
public interface UserService {

    /**
     * 创建用户
     * @param userDO 用户实体类
     * @return 用户ID
     */
    Long createUser(UserDO userDO);

    /**
     * 根据用户名称查询用户
     * @param username 用户名称
     * @return 用户列表
     */
    List<UserDO> getUserByUsername(String username);

    /**
     * 查询所有用户
     * @return 用户列表
     */
    List<UserDO> listUsers();
}
