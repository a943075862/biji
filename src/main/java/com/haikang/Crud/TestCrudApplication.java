package com.haikang.Crud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.haikang.Crud.dao")
public class TestCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestCrudApplication.class, args);
    }

}
