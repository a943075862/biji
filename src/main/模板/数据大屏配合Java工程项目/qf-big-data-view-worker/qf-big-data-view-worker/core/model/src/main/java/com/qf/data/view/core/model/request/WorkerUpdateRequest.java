package com.qf.data.view.core.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/14  9:58
 */

/**
 * 添加工人时使用的请求体
 */
@Data
public class WorkerUpdateRequest implements Serializable {
    private Long id;

    private String name;

    private Boolean gender;

    private Integer age;

    private Boolean workType;

    private Boolean status;

    private Boolean flag;
}
