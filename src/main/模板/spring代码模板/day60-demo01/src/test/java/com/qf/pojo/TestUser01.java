package com.qf.pojo;

import com.qf.service.UserService;
import com.qf.service.impl.UserServicceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-ms--anno.xml")
public class TestUser01 {
    @Autowired
    private UserServicceImpl userServicce;
    @Autowired
    private User user;

    @Test
    public void getUser(){
        User user = userServicce.selectUser(1);
        System.out.println("user = " + user);
    }
    @Test
    public void deleteUser(){
        Integer integer =0;
        for (int i = 11; i <=30; i++) {
            integer =integer+ userServicce.deleteUser(i);
        }
        System.out.println("integer = " + integer);
    }
    @Test
    public void insertUser(){
        Integer integer=0;
        user.setUsername("qiba");
        user.setPassword("baqi");
        user.setNickname("七八");
        for (int i = 0; i < 20; i++) {
            integer =integer+ userServicce.insertUser(user);
        }
        System.out.println("integer = " + integer);
    }
    @Test
    public void getUsers(){
        List<User> users = userServicce.selectAllUser();
        for (User user1 : users) {
            System.out.println("user1 = " + user1);
        }
    }

}
