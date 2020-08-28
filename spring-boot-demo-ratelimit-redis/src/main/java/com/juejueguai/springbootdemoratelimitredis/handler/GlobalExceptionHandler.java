package com.juejueguai.springbootdemoratelimitredis.handler;

import cn.hutool.core.lang.Dict;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * <p>
 * 全局异常拦截
 * </p>
 *
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public Dict handler(RuntimeException ex) {
        return Dict.create().set("msg", ex.getMessage());
    }
}
