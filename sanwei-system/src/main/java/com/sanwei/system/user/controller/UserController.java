package com.sanwei.system.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pojo.CommonResult;

/**
 * UserController
 *
 * @author caiyang
 * @date 2026/4/5
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/listUsers")
    @ResponseBody
    public CommonResult<String> listUsers() {
        throw new RuntimeException("错误测试");
    }
}
