package com.qf.demo;

import org.junit.jupiter.api.Test;
import org.redisson.Redisson;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/11  19:05
 */
@SpringBootTest
public class TestBoolon {

    @Test
    public void testBoolon(){
        Config config = new Config();
        //设置redis服务器地址
        config.useSingleServer().setAddress("redis://192.168.85.132:6379");
        config.useSingleServer().setPassword("123456");
        //构建redisson
        RedissonClient redisson = Redisson.create(config);
        //得到nameList的布隆过滤器
        RBloomFilter<String> nameList = redisson.getBloomFilter("nameList");
        //初始化布隆过滤器，预计元素和设置误差率为百分之三，
        nameList.tryInit(10000000L,0.03);
        //将xiaoming添加到布隆过滤器中
        nameList.add("xiaoming");
        //测试布隆过滤器是否成功
        System.out.println(nameList.contains("zhangsan"));
        System.out.println(nameList.contains("lisi"));
        System.out.println(nameList.contains("xiaoming"));
    }



}
