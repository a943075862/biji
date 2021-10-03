package com.qf.java2103.ssm.mapper;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */

import com.qf.java2103.ssm.pojo.Department;

import java.util.List;

/**
 * 部门数据访问层
 */
public interface IDepartmentMapper {
    //查询所有部门
    List<Department> findAllDepartment();
}
