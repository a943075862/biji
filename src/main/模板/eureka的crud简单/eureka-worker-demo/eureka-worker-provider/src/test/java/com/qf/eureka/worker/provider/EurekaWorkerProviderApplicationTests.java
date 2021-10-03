package com.qf.eureka.worker.provider;

import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.service.worker.WorkerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EurekaWorkerProviderApplicationTests {

    @Autowired
    private WorkerService workerService;
    @Test
    void contextLoads() {
        WorkerPO workerPO = workerService.selectByPrimaryKey(1L);
        System.out.println(workerPO);
    }

}
