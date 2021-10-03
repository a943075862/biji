package com.qf.dao;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/01
 */

import com.qf.pojo.People;

/**
 * 人数据访问接口
 */
public interface PeopleDao {
    /**
     * 添加数据返回id
     * @return
     */
    public int insertPeopleGenId02(People people);
}
