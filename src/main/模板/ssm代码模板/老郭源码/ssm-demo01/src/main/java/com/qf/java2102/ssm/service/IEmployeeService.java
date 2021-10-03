package com.qf.java2102.ssm.service;

import com.github.pagehelper.PageInfo;
import com.qf.java2102.ssm.pojo.Employee;

import java.util.List;
import java.util.Map;

/**
 * @author ghy
 * @version 1.0
 */
public interface IEmployeeService {

    PageInfo<Employee> findAllAndDept(Integer pageNum, Integer pageSize);

    void deleteById(Long id);

    void save(Employee employee);

    Map<String, Object> findByIdAndDepts(Long id);

    void edit(Employee employee);
}
