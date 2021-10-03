package com.qf.data.view.facade.response.worker;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  20:16
 */

/**
 * 业务提供这传递给业务消费者的对象
 *      这里传递的为工人对象信息
 *              传给controller层向前端传递消息
 */
@Data
public class WorkerModelResponse implements Serializable {
    private Long id;

    private String name;

    private Boolean gender;

    private Integer age;

    private Boolean workType;

    private Boolean status;

    private Boolean flag;
}
