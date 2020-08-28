package com.example.springbootdemoratelimitguava.aspect;

import com.example.springbootdemoratelimitguava.annotation.RateLimit;
import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @description: 切面
 * @author: juejueguai
 * @date: 2020/8/28 13:38
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@Slf4j
@Aspect
@Component
public class RateLimitAspect {
    private static final ConcurrentMap<String, RateLimiter> RATE_LIMITER_CACHE = new ConcurrentHashMap<>(16);
    @Pointcut("@annotation(com.example.springbootdemoratelimitguava.annotation.RateLimit)")
    public void rateLimit() {

    }
    @Around("rateLimit()")
    public Object pointcut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();
        RateLimit rateLimit = AnnotationUtils.findAnnotation(method, RateLimit.class);
        if (Objects.nonNull(rateLimit) && rateLimit.qps() > RateLimit.NOT_LIMITED) {
            double qps = rateLimit.qps();
            // 缓存池中是否有对象 没有则初始化刷入
            if (Objects.isNull(RATE_LIMITER_CACHE.get(method.getName()))) {
                RATE_LIMITER_CACHE.put(method.getName(), RateLimiter.create(qps));
            }
            log.debug("[{}]的qps设置为：{}", method.getName(), RATE_LIMITER_CACHE.get(method.getName()).getRate());
            // 尝试获取令牌
            if (Objects.nonNull(RATE_LIMITER_CACHE.get(method.getName())) && !RATE_LIMITER_CACHE.get(method.getName()).tryAcquire(rateLimit.timeout(), rateLimit.timeUnit())) {
                throw new RuntimeException("请求次数过多,请稍后再试");
            }
        }
        return proceedingJoinPoint.proceed();

    }
}
