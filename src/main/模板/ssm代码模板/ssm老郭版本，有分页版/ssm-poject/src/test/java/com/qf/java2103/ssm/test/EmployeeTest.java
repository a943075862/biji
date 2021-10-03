package com.qf.java2103.ssm.test;

import com.github.pagehelper.PageInfo;
import com.qf.java2103.ssm.mapper.IEmployeeMapper;
import com.qf.java2103.ssm.pojo.Department;
import com.qf.java2103.ssm.pojo.Employee;
import com.qf.java2103.ssm.service.IEmployeeService;
import com.qf.java2103.ssm.service.impl.IEmployeeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmployeeTest {
    @Autowired
    private IEmployeeMapper employeeMapper;

    /**
     * 测试查询所有员工和部门
     */
    @Test
    public void getEmployeeAndDeptTest(){
        List<Employee> allEmployeeAndDept = employeeMapper.findAllEmployeeAndDept();
        for (Employee employee : allEmployeeAndDept) {
            System.out.println("employee = " + employee);
        }
    }

    @Autowired  //自动匹配对象
    private IEmployeeServiceImpl employeeService;
    /**
     * 测试事务
     */
    @Test
    public void serviceTxTest(){
        PageInfo<Employee> employees = employeeService.findAllEmployeeAndDept(1, 5);
        List<Employee> list = employees.getList();
        for (Employee employee : list) {
            System.out.println("employee = " + employee);
        }
    }
    /**
     * 测试通过id删除员工
     *      测试通过
     */
    @Test
    public void deleteByIdTest(){
        employeeService.deleteById(24);
    }
    /**
     *  测试添加员工
     *      测试通过
     */
    @Test
    public void insertEmployeeTest(){
            Employee employee = new Employee(1,"李四",2000.00,2,new Department());
            employeeService.insertEmployee(employee);
    }
    /**
     * 测试通过ID查询员工
     *          未连表查询部门
     *               测试通过
     */
    @Test
    public void findEmployeeByIdTest(){
        Employee employee = employeeService.findEmployeeById(1);
        System.out.println("employee = " + employee);
    }
    /**
     * 测试修改员工信息
     *      测试通过，修改成功
     */
    @Test
    public void updateEmployeeTest(){
        Employee employee = new Employee(10,"李四",2000.00,2,new Department());
        employeeService.updateEmployee(employee);
    }


}
