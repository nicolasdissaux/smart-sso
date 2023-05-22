package com.smart.core.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.beans.Transient;

@ApiModel(description = "响应结果")
public class Result<T> {

	public static final int SUCCESS_CODE = 200;
	public static final int ERROR_CODE = -1000;

	@ApiModelProperty("响应码")
	private Integer code;

	@ApiModelProperty("消息")
	private String msg;

	@ApiModelProperty("数据")
	private T data;

    public Result() {
    }

	public Result(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Result(Integer code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public static <T> Result<T> success() {
		return new Result<>(SUCCESS_CODE, Message.get(String.valueOf(SUCCESS_CODE)));
	}

	public static <T> Result<T> success(T data) {
		return new Result<>(SUCCESS_CODE, Message.get(String.valueOf(SUCCESS_CODE)), data);
	}

	public static <T> Result<T> error() {
		return new Result<>(ERROR_CODE, Message.get(String.valueOf(ERROR_CODE)));
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public T getData() {
		return data;
	}

	@Transient
	public boolean isSuccess() {
		return SUCCESS_CODE == this.code;
	}

	@Override
	public String toString() {
		return "Result{" +
				"code=" + code +
				", msg='" + msg + '\'' +
				", data=" + data +
				'}';
	}
}