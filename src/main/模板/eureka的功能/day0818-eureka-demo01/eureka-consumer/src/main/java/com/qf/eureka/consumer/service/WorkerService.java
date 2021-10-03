package com.qf.eureka.consumer.service;

import pojo.Worker;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  12:43
 */
public interface WorkerService {
    String getWorker(Long id);

    String getForProject(Long id, String name);

    String postGet(Worker worker);

    String postGetWithCookie(Worker worker, String cookie);
}
