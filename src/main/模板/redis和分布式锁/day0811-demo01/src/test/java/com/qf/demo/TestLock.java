package com.qf.demo;

import com.qf.demo.pojo.Site;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/11  19:19
 */
@SpringBootTest
public class TestLock {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private RedissonClient redissonClient;

    @Test
    public void testBreak(){
        //创建多线程，模拟并发，让100条线程一起执行取值操作
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        for (int i = 0; i <100 ; i++) {
            //创建多线程需要执行的任务
            Runnable runnable=new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    //执行从缓存或数据库取值的操作
//                    getCash();
                    getCashByRedisson();
                }
            };
            //将任务提交到线程池中
            threadPool.submit(runnable);
        }
        try {
            Thread.sleep(11111111L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 模拟从redis缓存取值，redis缓存中没有值从数据库取值
     */
    @Test
    public void getCash(){
        //设置序列化器格式
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        //从redis缓存取值
        List<Site> list = (List<Site>) redisTemplate.opsForValue().get("site2:list");
        //判断缓存里是否为空，若为空，则从数据库取值
            if (Objects.isNull(list)){
                //获取用户专属uuid
                String valueUuid = UUID.randomUUID().toString();
                //设置工地查询锁
                Boolean siteLock = redisTemplate.opsForValue().setIfAbsent("lock:site", valueUuid, 60, TimeUnit.SECONDS);
                if (siteLock){
                    try {
                        //模拟数据库中返回的数据
                        ArrayList<Site> valueList = new ArrayList<>();
                        Site site = new Site(10001L,"设备1");
                        Site site2 = new Site(10002L,"设备2");
                        valueList.add(site);
                        valueList.add(site2);
                        System.out.println("从数据库获取数据");
                        //将取到的对象放到缓存中
                        redisTemplate.opsForValue().set("site2:list",valueList,60,TimeUnit.SECONDS);
                    } finally {
                        String uuid = (String) redisTemplate.opsForValue().get("lock:site");
                        if (uuid.equals(valueUuid)){
                            redisTemplate.delete("lock:site");
                        }
                    }
                }else {
                    try {
                        Thread.sleep(10);
                        getCash();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                System.out.println(" 从缓存中取值");
            }

    }

    /**
     * 模拟从redis缓存取值，redis缓存中没有值从数据库取值
     */
    @Test
    public void getCashByRedisson(){
        //设置序列化器格式
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new StringRedisSerializer());
        //从redis缓存取值
        RLock redissonClientLock = redissonClient.getLock("site1:redission:lock");
        try {
            redissonClientLock.lock();
            List<Site> list = (List<Site>) redisTemplate.opsForValue().get("site2:list");
//            System.out.println("list = " + list);
            //判断缓存里是否为空，若为空，则从数据库取值
            if (Objects.isNull(list)){
                //获取用户专属uuid
               /* String valueUuid = UUID.randomUUID().toString();
                //设置工地查询锁
                Boolean siteLock = redisTemplate.opsForValue().setIfAbsent("lock:site", valueUuid, 60, TimeUnit.SECONDS);
                if (siteLock){*/
    //                    redissonClientLock.lock();
    //                    System.out.println(redissonClientLock.isLocked());
                        //模拟数据库中返回的数据
                        ArrayList<Site> valueList = new ArrayList<>();
                        Site site = new Site(10001L,"设备1");
                        Site site2 = new Site(10002L,"设备2");
                        valueList.add(site);
                        valueList.add(site2);
                System.out.println("从数据库获取数据");
//                        System.out.println(10/0);
                        //将取到的对象放到缓存中
                        redisTemplate.opsForValue().set("site2:list",valueList,60,TimeUnit.SECONDS);
//                        redissonClientLock.unlock();
                        /*String uuid = (String) redisTemplate.opsForValue().get("lock:site");
                        if (uuid.equals(valueUuid)){
                            System.out.println("1111");
                            redisTemplate.delete("lock:site");
                        }*/
               /* }else {
                    try {
                        Thread.sleep(10);
                        getCash();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }*/
            }else{
                System.out.println(" 从缓存中取值");
            }
        } finally {
             redissonClientLock.unlock();
        }
    }





}
