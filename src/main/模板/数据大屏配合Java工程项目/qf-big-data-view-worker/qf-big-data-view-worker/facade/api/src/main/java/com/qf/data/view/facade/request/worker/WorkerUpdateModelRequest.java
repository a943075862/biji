package com.qf.data.view.facade.request.worker;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/14  10:08
 */

/**
 * 消费者向业务提供者传递的参数对象
 *          传递的是修改工人的信息
 */
@Data
public class WorkerUpdateModelRequest implements Serializable {
    private Long id;

    private String name;

    private Boolean gender;

    private Integer age;

    private Boolean workType;

    private Boolean status;

    private Boolean flag;
}
