package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qf.dao")
public class Day68Demo05Application {

    public static void main(String[] args) {
        SpringApplication.run(Day68Demo05Application.class, args);
    }

}
