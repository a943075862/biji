package com.qf.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 模拟数据库取值
     * @param id
     * @return
     */
    public String getSql(Integer id){
        //模拟数据库中没有值，返回null
        //如果id大于10数据库中就没有值
        if (id>10){
            return null;
        }else {
            //否则返回值
            return "v"+id;
        }
    }


    @Test
    public void testCashBoom(){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        for (int i = 21; i <=30; i++) {
            Object value = redisTemplate.opsForValue().get("k" + i);

            if (Objects.isNull(value)) {
                String sql = getSql(i);
                if (Objects.isNull(sql)){
                    sql=new String();
                    redisTemplate.opsForValue().set("k"+i,sql,300, TimeUnit.SECONDS);
                    System.out.println("数据库取值");
                }else {
                    //数据库中有值的情况下写入到缓存
                    redisTemplate.opsForValue().set("k"+i,sql);
                    System.out.println("数据库取值");
                }
            }else {
                String val = (String) value;
                System.out.println("缓存取值  值val = " + val);
            }
        }
    }






}
