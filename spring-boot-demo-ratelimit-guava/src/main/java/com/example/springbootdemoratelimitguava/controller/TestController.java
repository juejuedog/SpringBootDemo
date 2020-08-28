package com.example.springbootdemoratelimitguava.controller;

import cn.hutool.core.lang.Dict;
import com.example.springbootdemoratelimitguava.annotation.RateLimit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试控制层
 * @author: juejueguai
 * @date: 2020/8/28 14:06
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {
    @RateLimit(value = 1.0, timeout = 300)
    @GetMapping("/test1")
    public Dict test1() {
        log.info("【test1】被执行了。。。。。");
        return Dict.create().set("msg", "hello,world!").set("description", "别想一直看到我，不信你快速刷新看看~");
    }

    @GetMapping("/test2")
    public Dict test2() {
        log.info("【test2】被执行了。。。。。");
        return Dict.create().set("msg", "hello,world!").set("description", "我一直都在，卟离卟弃");
    }

    @RateLimit(value = 2.0, timeout = 300)
    @GetMapping("/test3")
    public Dict test3() {
        log.info("【test3】被执行了。。。。。");
        return Dict.create().set("msg", "hello,world!").set("description", "别想一直看到我，不信你快速刷新看看~");
    }
}
