package com.example.springbootdemoratelimitguava.hanler;

import cn.hutool.core.lang.Dict;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @description: 全局异常处理
 * @author: juejueguai
 * @date: 2020/8/28 14:04
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(RuntimeException.class)
    public Dict handler(RuntimeException exception) {
        return Dict.create().set("msg", exception.getMessage());
    }
}
