package com.qf.eureka.worker.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EurekaWorkerConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaWorkerConsumerApplication.class, args);
    }

}
