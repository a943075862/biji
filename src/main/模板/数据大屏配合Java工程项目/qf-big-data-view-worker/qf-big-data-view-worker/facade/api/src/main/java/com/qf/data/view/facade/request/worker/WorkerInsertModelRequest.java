package com.qf.data.view.facade.request.worker;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/14  10:08
 */

/**
 * 添加工人向service层传输对象
 *          传递的是新增用户的信息
 */
@Data
public class WorkerInsertModelRequest implements Serializable {
    private Long id;

    private String name;

    private Boolean gender;

    private Integer age;

    private Boolean workType;

    private Boolean status;

    private Boolean flag;
}
