package com.qf.eureka.worker.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.qf.data.core.dal.dao.worker")
@ComponentScan(value = "com.qf")
public class EurekaWorkerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaWorkerProviderApplication.class, args);
    }

}
