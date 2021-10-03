package com.qf.java2103.ssm.service;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */

import com.github.pagehelper.PageInfo;
import com.qf.java2103.ssm.pojo.Employee;

import java.util.List;

/**
 * 员工业务层接口
 */
public interface IEmployeeService {
    //查找所有员工和部门
    PageInfo<Employee> findAllEmployeeAndDept(Integer pageNum, Integer pageSize);

    //通过id删除员工
    Integer deleteById(Integer id);

    //添加员工
    Integer insertEmployee(Employee employee);

    //通过id查询员工
    Employee findEmployeeById(Integer id);

    //修改员工信息
    Integer updateEmployee(Employee employee);


}
