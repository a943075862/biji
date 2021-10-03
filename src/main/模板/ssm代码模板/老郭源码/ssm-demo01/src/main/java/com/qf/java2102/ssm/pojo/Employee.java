package com.qf.java2102.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ghy
 * @version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    private Long id;
    private String empName;
    private Double salary;
    private Long deptId;
    private Department department;

}
