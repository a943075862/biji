package com.qf.java2103.ssm.service;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */

import com.qf.java2103.ssm.pojo.Department;

import java.util.List;

/**
 * 部门业务层接口
 */
public interface IDepartmentService {
    //查询所有部门
    List<Department> findAllDepartment();
}
