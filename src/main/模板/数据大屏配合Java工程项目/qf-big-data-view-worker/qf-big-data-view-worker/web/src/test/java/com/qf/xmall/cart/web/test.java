package com.qf.xmall.cart.web;

import com.qf.bigdata.view.web.service.WorkerService;
import com.qf.bigdata.view.web.service.impl.WorkerServiceImpl;
import com.qf.data.view.core.model.response.WorkerResponse;
import com.qf.data.view.core.model.result.ResultModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/14  9:38
 */
@SpringBootTest
public class test {
    @Autowired
    private WorkerService workerService;
    @Test
    public void test(){
        ResultModel<List<WorkerResponse>> workerAll = workerService.getWorkerAll();
        System.out.println("workerAll = " + workerAll);
    }
}
