package com.qf.service;

import com.qf.pojo.User;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/09
 */

/**
 * 业务层接口
 */
public interface UserService {
    public Integer insertUser(User user);

    public Integer deleteUser(Integer id);

    public Integer updateUser(User user);

    public User selectUser(Integer id);

    public List<User> selectAllUser();
}
