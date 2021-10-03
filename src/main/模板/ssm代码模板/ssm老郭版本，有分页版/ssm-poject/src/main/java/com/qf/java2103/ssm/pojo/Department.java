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
 * 部门类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    //部门Id
    private Integer id;
    //部门名称
    private String deptName;


}
