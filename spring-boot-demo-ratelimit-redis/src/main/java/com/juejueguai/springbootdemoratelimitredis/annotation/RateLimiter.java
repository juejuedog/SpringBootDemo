package com.juejueguai.springbootdemoratelimitredis.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * @description: 限流注解
 * @author: juejueguai
 * @date: 2020/8/13 15:29
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter {
    long DEFAULT_REQUEST = 10;
    /**
     * max 最大请求数
     */
    @AliasFor("max")
    long value() default DEFAULT_REQUEST;

    /**
     * max 最大请求数
     */
    @AliasFor("value")
    long max() default DEFAULT_REQUEST;

    /**
     * 限流key
     */
    String key() default "";

    /**
     * 超时时长，默认1分钟
     */
    long timeout() default 1;

    /**
     * 超时时间单位，默认 分钟
     */
    TimeUnit timeUnit() default TimeUnit.MINUTES;
}
