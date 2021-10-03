package com.qf.service;

import com.qf.dao.UserMapper;
import com.qf.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/2  14:06
 */

public interface UserService {
    List<User> selectAll();
    User selectByUsername(User user);
    Integer insert(User user);
    User selectByUsername2(User user);
}
