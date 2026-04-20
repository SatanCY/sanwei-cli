package com.sanwei.system.service.user;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sanwei.system.controller.auth.vo.AuthRegisterReqVO;
import com.sanwei.system.controller.user.vo.UserSaveReqVO;
import com.sanwei.system.dal.dataobject.user.UserDO;
import com.sanwei.system.dal.mysql.user.UserMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * UserServiceImpl
 * 用户服务接口实现
 * @author caiyang
 * @date 2026/4/15
 */
@Service("userService")
@Slf4j
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Long createUser(UserSaveReqVO createReqVO) {
        UserDO user = BeanUtil.toBean(createReqVO, UserDO.class);
        user.setPassword(encodePassword(createReqVO.getPassword()));
        userMapper.insert(user);
        return user.getId();
    }

    @Override
    public List<UserDO> getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(UserDO::getUsername, username);
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public List<UserDO> listUsers() {
        return userMapper.selectList(new LambdaQueryWrapper<>());
    }

    @Override
    public Long registerUser(AuthRegisterReqVO registerReqVO) {
        return 0L;
    }

    /**
     * todo 使用security的加密方法加密密码
     * @param password 密码
     * @return 加密后的密码
     */
    private String encodePassword(String password) {
        return password;
    }
}
