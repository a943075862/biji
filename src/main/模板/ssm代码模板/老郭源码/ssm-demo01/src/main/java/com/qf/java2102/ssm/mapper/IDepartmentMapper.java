package com.qf.java2102.ssm.mapper;

import com.qf.java2102.ssm.pojo.Department;

import java.util.List;

/**
 * @author ghy
 * @version 1.0
 */
public interface IDepartmentMapper {

    List<Department> findAll();

}
