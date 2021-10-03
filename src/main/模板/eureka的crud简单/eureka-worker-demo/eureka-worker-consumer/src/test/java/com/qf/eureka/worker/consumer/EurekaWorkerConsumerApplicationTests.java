package com.qf.eureka.worker.consumer;

import com.qf.data.view.core.model.result.ResultModel;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class EurekaWorkerConsumerApplicationTests {

    @Autowired
    private RestTemplate restTemplate;
    @Test
    void contextLoads() {
        String url ="http://WORKER-PROVIDER/worker/getAll";
        ResultModel forObject = restTemplate.getForObject(url, ResultModel.class);
//        ResponseEntity<ResultModel> forEntity = restTemplate.getForEntity(url, ResultModel.class);
//        System.out.println("forEntity = " + forEntity);
        System.out.println("forObject = " + forObject);
    }

}
