package com.qf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/2  14:07
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from users")
    List<User>  selectAll();
    @Select("select * from users where user_name=#{username}")
    User selectByUsername(String username);

}
