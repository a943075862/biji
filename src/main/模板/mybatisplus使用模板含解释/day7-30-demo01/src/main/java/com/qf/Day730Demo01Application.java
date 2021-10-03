package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.qf.mapper")
public class Day730Demo01Application {

    public static void main(String[] args) {
        SpringApplication.run(Day730Demo01Application.class, args);
    }

}
