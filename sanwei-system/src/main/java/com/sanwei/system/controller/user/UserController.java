package com.sanwei.system.controller.user;

import cn.hutool.core.collection.ListUtil;
import com.sanwei.framework.common.exception.ErrorCode;
import com.sanwei.framework.common.exception.ServiceException;
import com.sanwei.system.dal.dataobject.user.UserDO;
import com.sanwei.system.service.user.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import com.sanwei.framework.common.pojo.CommonResult;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Objects;

/**
 * UserController
 *
 * @author caiyang
 * @date 2026/4/5
 */
@Tag(name = "后台管理-用户模块")
@RestController
@RequestMapping("/system/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/createUser")
    @ResponseBody
    public CommonResult<Long> createUser(@Valid @RequestBody UserDO userDO) {
        Long userId = userService.createUser(userDO);
        if (Objects.isNull(userId)) {
            throw new ServiceException(new ErrorCode(300, "创建用户信息出错"));
        }
        return CommonResult.success(userId);
    }

    @GetMapping("/listUsers")
    @ResponseBody
    public CommonResult<List<UserDO>> listUsers() {
        return CommonResult.success(userService.listUsers());
    }
}
