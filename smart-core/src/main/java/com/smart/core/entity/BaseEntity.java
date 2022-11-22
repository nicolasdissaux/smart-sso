package com.smart.core.entity;
import com.smart.core.entity.Entity;

/**
 * 基础持久化基类
 * 
 * @author Joe
 */
public class BaseEntity extends Entity<Integer> {

	private static final long serialVersionUID = 1496181940497282708L;

	public BaseEntity() {
		super();
	}

	public BaseEntity(Integer id) {
		super(id);
	}

	/**
	 * 解决Spring使用BeanUtils.copyProperties泛型父类属性copy为null问题
	 */
	@Override
	public Integer getId() {
		return super.getId();
	}
}