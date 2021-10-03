package com.qf.java2103.ssm.test;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */

import com.qf.java2103.ssm.pojo.Department;
import com.qf.java2103.ssm.service.IDepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 部门测试类
 */
@ContextConfiguration(locations = {"classpath*:spring/applicationContext-*.xml"})  //spring测试配置文件引入
@RunWith(SpringJUnit4ClassRunner.class)     //spring测试标识
public class DepartmentTest {
    @Autowired
    private IDepartmentService departmentService;

    @Test
    public void getAllDeptTest(){
        List<Department> departments = departmentService.findAllDepartment();
        for (Department department : departments) {
            System.out.println("department = " + department);
        }
    }

}
