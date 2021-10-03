package com.qf.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qf.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/30  14:32
 */
@Mapper
public interface IUserMapper extends BaseMapper<User> {
    List<User> findAll();

}
