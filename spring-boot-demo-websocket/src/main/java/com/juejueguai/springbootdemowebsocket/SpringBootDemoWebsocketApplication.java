package com.juejueguai.springbootdemowebsocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
public class SpringBootDemoWebsocketApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDemoWebsocketApplication.class, args);
    }

}
