package com.qf.java2103.ssm.pojo;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    //员工ID
    private Integer id;
    //员工名称
    private String empName;
    //薪水
    private Double salary;
    //部门Id
    private Integer deptId;
    //多表联查，显示数据用
    private Department department;


}
