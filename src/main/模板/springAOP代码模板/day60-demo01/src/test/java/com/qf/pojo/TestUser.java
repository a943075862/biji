package com.qf.pojo;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/09
 */
public class TestUser {
    /**
     * bean的生命周期
     *      构造---set-----后处理器的before----init---后处理器的after----destory
     */
    @Test
    public void getUser(){
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContexxt.xml");
        User user = ioc.getBean(User.class);
        ioc.close();
    }
}
