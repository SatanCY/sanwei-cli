package com.sanwei.system.controller.user;

import com.sanwei.framework.common.exception.ErrorCode;
import com.sanwei.framework.common.exception.ServiceException;
import com.sanwei.system.controller.user.vo.UserSaveReqVO;
import com.sanwei.system.dal.dataobject.user.UserDO;
import com.sanwei.system.service.user.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import org.springframework.validation.annotation.Validated;
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
@Validated
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/createUser")
    @Operation(summary = "新增用户")
    public CommonResult<Long> createUser(@Valid @RequestBody UserSaveReqVO reqVO) {
        Long userId = userService.createUser(reqVO);
        if (Objects.isNull(userId)) {
            throw new ServiceException(new ErrorCode(300, "创建用户信息出错"));
        }
        return CommonResult.success(userId);
    }

    @GetMapping("/listUsers")
    @Operation(summary = "查询用户列表")
    public CommonResult<List<UserDO>> listUsers() {
        return CommonResult.success(userService.listUsers());
    }
}
