package com.haikang.Crud;

import com.haikang.Crud.pojo.User;
import com.haikang.Crud.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class TestCrudApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private UserService userService;
    @Test
    public void testSelectAll(){
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println("user = " + user);
        }
    }

}
