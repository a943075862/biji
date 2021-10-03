package com.qf.dao;

import com.qf.pojo.Employee;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/01
 */

/**
 * employee数据访问层
 */
public interface EmployeeDao {
    /**
     * 添加用户
     * @param employee
     * @return
     */
    public int insertEmployee(Employee employee);

    /**
     * 通过id删除
     * @param id
     * @return
     */
    public int deleteEmployee(int id);

    /**
     * 添加用户
     * @param employee
     * @return
     */
    public int updateEmployee(Employee employee);

    /**
     * 通过用户id查询用户
     * @param id
     * @return
     */
    public Employee showEmployeeById(int id);

    /**
     * 查询所有用户
     * @return
     */
    public List<Employee> showAllEmployee();

    /**
     * 通过用户名查询
     * @param username
     * @return
     */
    public List<Employee> showEmployeeByUsername(String username);

    /**
     * 添加员工，回填id
     * @param employee
     * @return
     */
    public int insertEmployeeGenId01(Employee employee);
    /**
     * 添加员工，回填id
     * @param employee
     * @return
     */
    public int insertEmployeeGenId02(Employee employee);



}
