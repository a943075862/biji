package com.qf.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.lang.Nullable;

import java.util.Random;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/09
 */
public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    @Nullable
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("后处理器的before====bean = " + bean+ "beanName="+beanName);
        return bean;
    }

    @Override
    @Nullable
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("after====bean = " + bean+ "beanName="+beanName);
        return bean;
    }

}
