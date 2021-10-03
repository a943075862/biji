package com.qf.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import com.qf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/2  14:10
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll() {
        List<User> users = userMapper.selectAll();
        return users;
    }

    @Override
    public User selectByUsername(User user) {
        return userMapper.selectByUsername(user.getUserName());
    }

    @Override
    public Integer insert(User user) {
        user.setUserStatus(0);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        return  userMapper.insert(user);

    }

    @Override
    public User selectByUsername2(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.eq("user_name",user.getUserName());
        User user1 = userMapper.selectOne(wrapper);
        return user1;
    }


}
