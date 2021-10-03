package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qf.dao")
public class Day0802Demo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Day0802Demo01Application.class, args);
    }

}
