package com.smart.core.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.core.entity.BaseEntity;
import com.smart.core.service.BaseService;

/**
 * 基础Service基类
 *
 * @param <M>
 * @param <T>
 * @author Joe
 */
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity> extends ServiceImpl<M, T> implements BaseService<T> {
}