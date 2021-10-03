package com.haikang.Crud.service;

import com.haikang.Crud.pojo.User;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/10/3  9:58
 */
public interface UserService  {
    List<User> selectAll();
}
