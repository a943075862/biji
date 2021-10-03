package com.qf.feign.consumer.service;

import pojo.Worker;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  18:04
 */
public interface WorkerService {

  String getWorker(Long id);

    String postgetWithCookie1(Worker worker);
}
