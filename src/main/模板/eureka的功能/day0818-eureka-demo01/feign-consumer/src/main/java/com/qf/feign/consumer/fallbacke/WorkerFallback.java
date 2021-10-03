package com.qf.feign.consumer.fallbacke;

import com.qf.feign.consumer.api.WorkerFeignAPI;
import org.springframework.stereotype.Component;
import pojo.Worker;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/18  12:29
 */
@Component
public class WorkerFallback implements WorkerFeignAPI {
    @Override
    public String getWorker(Long id) {
        return "请查看网络状况";
    }

    @Override
    public String postGetWithCookie1(Worker worker) {
        return "请查看网络状况";
    }
}
