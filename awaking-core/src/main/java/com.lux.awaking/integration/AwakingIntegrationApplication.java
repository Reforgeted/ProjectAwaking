package com.lux.awaking.integration;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lux.awaking")
@MapperScan("com.lux.awaking.integration.db.mapper")
public class AwakingIntegrationApplication {
    public static void main(String[] args) {
        SpringApplication.run(AwakingIntegrationApplication.class, args);
    }
}
