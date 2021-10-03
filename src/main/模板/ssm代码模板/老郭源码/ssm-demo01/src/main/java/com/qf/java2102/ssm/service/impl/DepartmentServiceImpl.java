package com.qf.java2102.ssm.service.impl;

import com.qf.java2102.ssm.mapper.IDepartmentMapper;
import com.qf.java2102.ssm.pojo.Department;
import com.qf.java2102.ssm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ghy
 * @version 1.0
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentMapper departmentMapper;

    @Override
    public List<Department> findAll() {
        return departmentMapper.findAll();
    }
}
