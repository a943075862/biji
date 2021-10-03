package com.qf.java2102.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.java2102.ssm.mapper.IDepartmentMapper;
import com.qf.java2102.ssm.mapper.IEmployeeMapper;
import com.qf.java2102.ssm.pojo.Department;
import com.qf.java2102.ssm.pojo.Employee;
import com.qf.java2102.ssm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ghy
 * @version 1.0
 */
@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeMapper employeeMapper;

    @Autowired
    private IDepartmentMapper departmentMapper;

    @Override
    public PageInfo<Employee> findAllAndDept(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(employeeMapper.findAllAndDept());
    }

    @Override
    public void deleteById(Long id) {
        employeeMapper.deleteById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeMapper.save(employee);
    }

    @Override
    public Map<String, Object> findByIdAndDepts(Long id) {

        Employee employee = employeeMapper.findById(id);
        List<Department> depts = departmentMapper.findAll();
        Map<String, Object> result = new HashMap<>();
        result.put("employee", employee);
        result.put("depts", depts);

        return result;
    }

    @Override
    public void edit(Employee employee) {
        employeeMapper.edit(employee);
    }
}
