package com.qf.eureka.worker.consumer.controller;

import com.qf.data.view.core.model.result.ResultModel;
import com.qf.eureka.worker.consumer.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  20:11
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @GetMapping("/getAll")
    public ResultModel getAll(){
        return workerService.getAll();
    }

    @GetMapping("/get/{id}")
    public ResultModel getWorker(@PathVariable Long id){
        return workerService.getWorkById(id);
    }
    @GetMapping("/delete/{id}")
    public ResultModel deleteWorker(@PathVariable Long id){
        return workerService.deleteById(id);
    }

}
