package com.qf.service.impl;

import com.qf.mapper.UserDao;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/09
 */
@Service
public class UserServicceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Integer insertUser(User user) {
        Integer integer = userDao.insertUser(user);
        return integer;
    }

    @Override
    @Transactional
    public Integer deleteUser(Integer id) {
        Integer integer = userDao.deleteUser(id);
//        System.out.println(10/0);
        return integer;
    }

    @Override
    public Integer updateUser(User user) {
        Integer integer = userDao.updateUser(user);
        return integer;
    }

    @Override
    @Transactional
    public User selectUser(Integer id) {
        User user = userDao.selectUser(id);
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = userDao.selectAllUser();
        return users;
    }
}
