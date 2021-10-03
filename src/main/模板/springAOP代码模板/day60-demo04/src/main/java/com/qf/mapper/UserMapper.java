package com.qf.mapper;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/12
 */

public interface UserMapper {

    public Integer deleteUser(Integer id);

    @Select("select * from users where id=#{id}")
    public User selectUser(Integer id);

    @Select("select * from users")
    public List<User> selectAllUser();

}
