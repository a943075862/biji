package com.qf.eureka.zuul.filiter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/18  17:33
 */
@Component
public class RequestLimitZuulFiliter extends ZuulFilter {
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 指明过滤器类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 指明过滤器优先级
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 是否执行过滤,如果有多个过滤器的，这个地方要设置成false，最后一个过滤器设置成true
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 执行具体的业务：做一个计数器限流，限制后端服务的访问数5个，访问数谁来维护
     *  重点关注：放行和不放行
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        //往redis添加一次
        Long count = redisTemplate.opsForValue().increment("zuul-count");
        if (count==1){
            //如果返回1则设置生命周期
            redisTemplate.expire("zuul-count",60, TimeUnit.SECONDS);
        }
        //如果count小于等于7，则进行跳转
        if (count<=7){
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            return null;
        }
        //否则输出达到最大请求数
        context.setSendZuulResponse(false);
        context.setResponseStatusCode(200);
        String message="request reach max";
        context.setResponseBody(message);
        return null;
    }
}
