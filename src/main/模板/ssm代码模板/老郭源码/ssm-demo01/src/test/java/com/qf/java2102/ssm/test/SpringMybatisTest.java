package com.qf.java2102.ssm.test;

import com.qf.java2102.ssm.mapper.IEmployeeMapper;
import com.qf.java2102.ssm.pojo.Employee;
import com.qf.java2102.ssm.service.IEmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author ghy
 * @version 1.0
 */
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringMybatisTest {

@Autowired
    IEmployeeMapper employeeMapper;

    /**
     *
     * @throws Exception
     */
    @Test
    public void findAllAndDeptTest() throws Exception {
        List<Employee> emps = employeeMapper.findAllAndDept();
        for (Employee emp : emps) {
            System.out.println("emp = " + emp);
        }
    }

    @Autowired
    IEmployeeService employeeService;

    /**
     *
     * @throws Exception
     */
    @Test
    public void employeeServiceTest() throws Exception {
        /*List<Employee> employees = employeeService.findAllAndDept();
        for (Employee employee : employees) {
            System.out.println("employee = " + employee);
        }*/
    }

}
