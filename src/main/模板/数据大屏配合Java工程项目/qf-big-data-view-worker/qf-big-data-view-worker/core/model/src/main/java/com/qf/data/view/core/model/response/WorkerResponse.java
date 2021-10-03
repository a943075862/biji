package com.qf.data.view.core.model.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  20:11
 */
@Data
public class WorkerResponse implements Serializable {

    private Long id;

    private String name;

    private Boolean gender;

    private Integer age;

    private Boolean workType;

    private Boolean status;

    private Boolean flag;

}
