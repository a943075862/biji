package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qf.dao")
public class SsmSpringBootDemo01Application {

    public static void main(String[] args) {
        SpringApplication.run(SsmSpringBootDemo01Application.class, args);
    }

}
