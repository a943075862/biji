package com.qf.eureka.worker.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaWorkerCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaWorkerCenterApplication.class, args);
    }

}
