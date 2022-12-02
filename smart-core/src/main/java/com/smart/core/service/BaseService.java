package com.smart.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.smart.core.entity.BaseEntity;

/**
 * 基础Service接口
 *
 * @param <T>
 * @author Joe
 */
public interface BaseService<T extends BaseEntity> extends IService<T> {
}