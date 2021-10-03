package com.qf.java2103.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.java2103.ssm.mapper.IEmployeeMapper;
import com.qf.java2103.ssm.pojo.Employee;
import com.qf.java2103.ssm.service.IEmployeeService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */

/**
 * 员工业务层接口实现类
 */
@Service   //业务层注解
@Transactional  //事务注解
//@Aspect //切面注解
public class IEmployeeServiceImpl implements IEmployeeService {
    @Autowired  //自动匹配对象
   private IEmployeeMapper employeeMapper;

    /**
     * 查询所有员工和对应的部门信息
     *      调用mapper中的findAllEmployeeAndDept方法
     * @return
     */
    @Override
    public PageInfo<Employee> findAllEmployeeAndDept(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Employee> employees = employeeMapper.findAllEmployeeAndDept();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);

        return pageInfo;
    }
    /**
     * 通过id删除员工
     *      调用mapper中的deleteById方法
     * @return
     */
    @Override
    public Integer deleteById(Integer id) {

        Integer integer = employeeMapper.deleteById(id);
        System.out.println("integer = " + integer);
//        System.out.println(10/0);
        return integer;
    }
    /**
     * 添加员工
     *      调用mapper中的insertEmployee方法
     * @return
     */
    @Override
    public Integer insertEmployee(Employee employee) {
          return   employeeMapper.insertEmployee(employee);
    }
    /**
     * 通过id查询员工
     *      调用mapper中的findEmployeeById方法
     * @return
     */
    @Override
    public Employee findEmployeeById(Integer id) {
        Employee employee = employeeMapper.findEmployeeById(id);
        return employee;
    }
    /**
     * 修改员工信息
     *      调用mapper中的updateEmployee方法
     * @return
     */
    @Override
    public Integer updateEmployee(Employee employee) {
        return employeeMapper.updateEmployee(employee);
    }
}
