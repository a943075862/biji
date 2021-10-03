package com.qf.java2103.ssm.service.impl;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */

import com.qf.java2103.ssm.mapper.IDepartmentMapper;
import com.qf.java2103.ssm.pojo.Department;
import com.qf.java2103.ssm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门业务接口实现类
 */
@Service    //业务层标识
@Transactional  //事务注解
public class IDepartmentServiceImpl implements IDepartmentService {
    @Autowired
    private IDepartmentMapper departmentMapper;

    /**
     * 查询所有部门
     *      同过调用mapper中的findAllDepartment方法
     * @return
     */
    @Override
    public List<Department> findAllDepartment() {
        List<Department> departments = departmentMapper.findAllDepartment();
        return departments;
    }
}
