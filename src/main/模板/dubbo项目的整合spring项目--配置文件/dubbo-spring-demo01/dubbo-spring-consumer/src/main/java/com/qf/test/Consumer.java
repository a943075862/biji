package com.qf.test;

import com.qf.dubbo.pojo.Site;
import com.qf.dubbo.service.SiteService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/12  17:08
 */
public class Consumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();
         /*
    下面这一整个过程。都是在执行远程过程调用—— rpc remote produce call 服务框架
     */
        //获取一个代理，代理服务提供者内提供的bean
        SiteService siteService = (SiteService) context.getBean("siteService");
        Site site = siteService.getSite(1001L);
        System.out.println("site = " + site);

    }
}
