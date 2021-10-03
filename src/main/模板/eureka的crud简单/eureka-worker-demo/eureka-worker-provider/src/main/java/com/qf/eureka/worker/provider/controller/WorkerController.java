package com.qf.eureka.worker.provider.controller;

import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.model.result.ResultModel;
import com.qf.data.view.core.service.worker.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  18:53
 */
@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    @RequestMapping("/get/{id}")
    public ResultModel getWorkerById(@PathVariable Long id){
        WorkerPO workerPO = workerService.selectByPrimaryKey(id);
        return ResultModel.success(workerPO);
    }
    @GetMapping("/getAll")
    public ResultModel getWorkers(){
        List<WorkerPO> workerPOS = workerService.selectAll();
        return ResultModel.success(workerPOS);
    }
    @GetMapping("/delete/{id}")
    public ResultModel deleteWorker(@PathVariable Long id){
        int i = workerService.deleteByPrimaryKey(id);
        if (i!=0){
            return ResultModel.success(i);
        }else {
            return ResultModel.error("删除失败");
        }
    }
    @PostMapping("/update")
    public ResultModel updateWorker(@RequestBody WorkerPO workerPO){
        int i = workerService.updateByPrimaryKeySelective(workerPO);
        if (i!=0){
            return ResultModel.success(i);
        }else {
            return ResultModel.error("修改失败");
        }
    }
    @PostMapping("/insert")
    public ResultModel insertWorker(@RequestBody WorkerPO workerPO){
        int i = workerService.insertSelective(workerPO);
        if (i!=0){
            return ResultModel.success(i);
        }else {
            return ResultModel.error("添加失败");
        }
    }

}
