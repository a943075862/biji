package com.qf.java2102.ssm.service;

import com.qf.java2102.ssm.pojo.Department;

import java.util.List;

/**
 * @author ghy
 * @version 1.0
 */
public interface IDepartmentService {

    List<Department> findAll();
}
