package com.qf.feign.consumer.api;

import com.qf.feign.consumer.fallbacke.WorkerFallback;
import com.qf.feign.consumer.interceptor.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pojo.Worker;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  17:50
 */

/**
 * ,configuration = FeignInterceptor.class
 * 以上配置拦截器来实现携带cookie的效果，
 *      加上拦截器后熔断器hystrix会直接生效，无法正确访问
 *              会直接跳转熔断后到页面
 */
@FeignClient(value = "WORKER-PROVIDER" ,fallback = WorkerFallback.class)
public interface WorkerFeignAPI {

    @RequestMapping("/worker/get/{id}")
    public String getWorker(@PathVariable(name = "id") Long id);

    @PostMapping("/worker/postgetWithCookie1")
    public String postGetWithCookie1(@RequestBody Worker worker);

}
