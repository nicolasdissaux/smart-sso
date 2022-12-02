package com.smart.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.core.Result;
import com.smart.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public Result selectPage(String name,
                             @RequestParam(defaultValue = "1") Integer pageNo,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.createSuccess(userService.selectPage(name, new Page<>(pageNo, pageSize)));
    }
}