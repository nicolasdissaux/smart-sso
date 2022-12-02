package com.smart.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.core.service.BaseService;
import com.smart.system.entity.User;

public interface UserService extends BaseService<User> {

    IPage<User> selectPage(String name, IPage<User> page);
}