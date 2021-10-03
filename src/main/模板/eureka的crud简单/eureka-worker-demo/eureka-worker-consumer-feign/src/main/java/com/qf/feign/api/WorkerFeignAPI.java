package com.qf.feign.api;

import com.qf.data.core.dal.po.worker.WorkerPO;
import com.qf.data.view.core.model.result.ResultModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  23:01
 */
@FeignClient("WORKER-PROVIDER")
public interface WorkerFeignAPI {
    @PostMapping("/worker/update")
    public ResultModel updateWorker(@RequestBody WorkerPO workerPO);
    @PostMapping("/worker/insert")
    public ResultModel insertWorker(@RequestBody WorkerPO workerPO);
}
