package com.qf.controller;

import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.annotation.Resources;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  21:11
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private  WorkerService workerService;
    @PostMapping("/update")
    public ResultModel updateWorker(@RequestBody WorkerPO workerPO){
       return workerService.updateWorker(workerPO);
    }
    @PostMapping("/insert")
    public ResultModel insertWorker(@RequestBody WorkerPO workerPO){
        return workerService.insertWorker(workerPO);
    }
}
