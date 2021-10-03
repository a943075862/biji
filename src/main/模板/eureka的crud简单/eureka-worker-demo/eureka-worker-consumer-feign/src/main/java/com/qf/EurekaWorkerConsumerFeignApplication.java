package com.qf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@MapperScan("com.qf.data.core.dal.dao.worker")
public class EurekaWorkerConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaWorkerConsumerFeignApplication.class, args);
    }

}
