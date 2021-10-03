package com.qf.data.view.facade.service;

import com.qf.data.core.dal.dao.worker.WorkerMapper;
import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.model.request.WorkerInsertRequest;
import com.qf.data.view.core.model.request.WorkerUpdateRequest;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.facade.request.worker.WorkerModelRequest;
import com.qf.data.view.facade.response.worker.WorkerIntModelReponse;
import com.qf.data.view.facade.response.worker.WorkerModelResponse;
import com.qf.data.view.facade.service.worker.WorkerFacadeImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.Request;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/14  9:40
 */
@SpringBootTest
public class test {
    @Autowired
    private WorkerFacadeImpl workerFacade;
    @Autowired
    private WorkerMapper workerMapper;
    @Test
    public void test(){
        ResultModel<List<WorkerModelResponse>> workers = workerFacade.getWorkers();
        System.out.println("workers = " + workers);
    }

    @Test
    public void test01(){
        List<WorkerPO> workerPOS = workerMapper.selectAll();
        System.out.println("workerPOS = " + workerPOS);
    }
    @Test
    public void test03(){
        WorkerInsertRequest workerInsertRequest = new WorkerInsertRequest();
        workerInsertRequest.setName("zhaoliu");
        ResultModel<WorkerIntModelReponse> insertWorker = workerFacade.insertWorker(workerInsertRequest);
        System.out.println("insertWorker = " + insertWorker);
    }
    @Test
    public void test04(){
        WorkerPO workerPO = new WorkerPO();
        workerPO.setName("zhaoliu");
        int insert = workerMapper.insert(workerPO);
        System.out.println("insert = " + insert);
    }
    @Test
    public void test05(){
        WorkerModelRequest request=new WorkerModelRequest();
        request.setId(7L);
        ResultModel<WorkerIntModelReponse> deleteWorkerById = workerFacade.deleteWorkerById(request);
        System.out.println("deleteWorkerById = " + deleteWorkerById);
    }
    @Test
    public void test06(){
        WorkerUpdateRequest req=new WorkerUpdateRequest();
        req.setId(3L);
        req.setName("lll");
        req.setAge(25);
        ResultModel<WorkerIntModelReponse> updateWorker = workerFacade.updateWorker(req);
        System.out.println("updateWorker = " + updateWorker);
    }



}
