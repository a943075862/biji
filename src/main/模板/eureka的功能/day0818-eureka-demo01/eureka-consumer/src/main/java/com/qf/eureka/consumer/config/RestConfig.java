package com.qf.eureka.consumer.config;

//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/17  12:40
 */
@Configuration
public class RestConfig {
    /**
     * 注入一个resttemplate的bean
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

   /* @Bean
//    @LoadBalanced
    public IRule myrule(){
        return new RandomRule();
    }*/
}
