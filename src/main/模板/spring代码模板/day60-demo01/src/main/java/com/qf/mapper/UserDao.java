package com.qf.mapper;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/09
 */

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 数据访问层
 */
@Repository
public interface UserDao {
    @Insert("INSERT INTO users(users.username,users.`password`,users.nickname) VALUES (#{username},#{password},#{nickname})")
    public Integer insertUser(User user);

    @Delete("delete from users where id=#{id}")
    public Integer deleteUser(Integer id);

    public Integer updateUser(User user);

    public User selectUser(Integer id);

    public List<User> selectAllUser();



}
