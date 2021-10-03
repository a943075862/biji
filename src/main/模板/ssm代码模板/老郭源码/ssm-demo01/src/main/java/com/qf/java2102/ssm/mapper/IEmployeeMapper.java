package com.qf.java2102.ssm.mapper;

import com.qf.java2102.ssm.pojo.Employee;

import java.util.List;

/**
 * @author ghy
 * @version 1.0
 */
public interface IEmployeeMapper {

    List<Employee> findAllAndDept();

    void deleteById(Long id);

    void save(Employee employee);

    Employee findById(Long id);

    void edit(Employee employee);
}
