package com.qf.pojo;

import com.qf.mapper.UserDao;
import com.qf.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/09
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-ms--anno.xml")
public class TestUser00 {
    @Autowired
    private UserService userService;
    @Test
    public void getUser01() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> users = userDao.selectAllUser();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

    /**
     * mybatis+spring
     * @throws IOException
     */
    @Test
    public void getUser02() throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext-ms.xml");
        UserDao userDao = ioc.getBean(UserDao.class);
        List<User> users = userDao.selectAllUser();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
    @Test
    public void getUser03() throws IOException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext-ms.xml");
        UserService userService = ioc.getBean(UserService.class);
        List<User> users = userService.selectAllUser();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
    @Test
    public void getUsers(){
        List<User> users = userService.selectAllUser();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }





}
