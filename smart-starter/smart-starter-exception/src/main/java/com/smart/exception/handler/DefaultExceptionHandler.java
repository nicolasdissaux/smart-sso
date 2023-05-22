package com.smart.exception.handler;

import com.smart.core.entity.Result;
import com.smart.exception.CommonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 公共异常拦截处理
 */
@Slf4j
@Order(100)
@ConditionalOnMissingBean(name = {"globalExceptionHandler"})
@RestControllerAdvice
public class DefaultExceptionHandler {

    /**
     * 自定义异常处理
     *
     * @param e
     * @return
     */
    @ExceptionHandler(CommonException.class)
    @ResponseBody
    public Object handleException(CommonException e) {
        return new Result<>(Integer.valueOf(e.getCode()), e.getMessage());
    }

    /**
     * 未知异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleException(Exception e) {
        log.error("global exception.", e);
        return Result.error();
    }
}