package com.smart.system.controller;

import com.smart.core.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/page")
    public Result selectPage(String name,
                             @RequestParam(defaultValue = "1") Integer pageNo,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        return Result.createSuccess(name);
    }
}