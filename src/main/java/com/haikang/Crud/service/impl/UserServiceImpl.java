package com.haikang.Crud.service.impl;

import com.haikang.Crud.dao.UserDao;
import com.haikang.Crud.pojo.User;
import com.haikang.Crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/10/3  9:59
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<User> selectAll() {
         return userDao.selectAll();
    }
}
