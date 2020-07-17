package com.juejueguai.springbootdemomybatisplus.config;


import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description: mybatisPlus配置
 * @author: juejueguai
 * @date: 2020/7/17 11:46
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 */
@Configuration
@MapperScan(basePackages = {"com.juejueguai.springbootdemomybatisplus.mapper"})
@EnableTransactionManagement
public class MybatisPlusConfig {

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
