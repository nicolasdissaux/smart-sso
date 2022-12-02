package com.smart.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.smart.core.service.impl.BaseServiceImpl;
import com.smart.system.entity.User;
import com.smart.system.mapper.UserMapper;
import com.smart.system.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {

    @Override
    public IPage<User> selectPage(String name, IPage<User> page) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.like(!StringUtils.isEmpty(name), User::getName, name);
        return page(page, wrapper);
    }
}