package com.qf.data.view.facade.service;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//扫描注入bean容器的对象
@ComponentScan(basePackages = "com.qf.data")
//开启dubbo
@EnableDubbo
//搜索mapper对象
@MapperScan("com.qf.data.core.dal")
public class ViewFacadeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViewFacadeServiceApplication.class, args);
    }

}
