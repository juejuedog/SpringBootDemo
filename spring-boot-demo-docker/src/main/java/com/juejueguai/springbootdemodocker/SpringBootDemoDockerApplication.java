package com.juejueguai.springbootdemodocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
/**
 * @description: 启动器
 * @author: juejueguai
 * @date: 2020/7/27 15:27
 * @copyright: Copyright (c) 2020
 * @version: V1.0
 * @modified: juejueguai
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class SpringBootDemoDockerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoDockerApplication.class, args);
    }

}
