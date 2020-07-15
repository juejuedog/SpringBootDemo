package com.juejueguai.cache.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class SpringBootDemoCacheRedisApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoCacheRedisApplication.class, args);
    }
}
