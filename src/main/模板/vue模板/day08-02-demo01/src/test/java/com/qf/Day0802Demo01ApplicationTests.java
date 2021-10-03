package com.qf;

import com.alibaba.fastjson.JSON;
import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Day0802Demo01ApplicationTests {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @Test
    public void selectAll(){
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }
    @Test
    void test01(){
        User user = new User();
        user.setUserName("zhangsan");
        user.setPassword("sanzhang");
        Object o = JSON.toJSON(user);
        System.out.println("o = " + o);
    }
    @Test
    void test02(){
        User user = new User();
        user.setUserName("zhangsan");
        User user1 = userService.selectByUsername(user);
        System.out.println("user1 = " + user1);
    }
    @Test
    void test03(){
        User user = new User();
        user.setUserName("123");
        user.setPassword("321");
        int insert = userMapper.insert(user);
        System.out.println("insert = " + insert);
    }
    @Test
    void test04(){
        User user = new User();
        user.setUserName("zhangsan");
        User user1 = userService.selectByUsername2(user);
        System.out.println("user1 = " + user1);
    }


}
