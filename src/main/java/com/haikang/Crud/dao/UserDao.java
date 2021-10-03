package com.haikang.Crud.dao;

import com.haikang.Crud.pojo.User;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/10/3  9:57
 */

public interface UserDao {
    List<User> selectAll();
}
