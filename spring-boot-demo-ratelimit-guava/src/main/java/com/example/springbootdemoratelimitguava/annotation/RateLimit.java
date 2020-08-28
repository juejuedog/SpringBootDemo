package com.example.springbootdemoratelimitguava.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @description: SpringBootDemo
 * @author: juejueguai
 * @date: 2020/8/28 11:48
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimit {
    int NOT_LIMITED = 0;

    @AliasFor("qps")
    double value() default NOT_LIMITED;


    @AliasFor("value")
    double qps() default NOT_LIMITED;

    /**
     * 超时时长
     */
    int timeout() default 0;


    /**
     * 超时时间单位
     */
    TimeUnit timeUnit() default TimeUnit.MILLISECONDS;
}
