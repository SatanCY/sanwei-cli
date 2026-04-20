package com.sanwei.system.service.user;

import com.sanwei.system.controller.auth.vo.AuthRegisterReqVO;
import com.sanwei.system.controller.user.vo.UserSaveReqVO;
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
     * @param createReqVO 用户 Request VO
     * @return 用户ID
     */
    Long createUser(UserSaveReqVO createReqVO);

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

    /**
     * 注册用户
     *
     * @param registerReqVO 用户信息
     * @return 用户编号
     */
    Long registerUser(AuthRegisterReqVO registerReqVO);
}
