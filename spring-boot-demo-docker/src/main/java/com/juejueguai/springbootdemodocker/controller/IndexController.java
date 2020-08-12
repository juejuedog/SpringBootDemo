package com.juejueguai.springbootdemodocker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 控制层
 * @author: juejueguai
 * @date: 2020/7/27 15:27
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@RestController
@RequestMapping
public class IndexController {
    @GetMapping
    public String test() {
        return "SUCCESS";
    }
}
