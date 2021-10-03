package com.qf.data.view.core.model.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/16  11:44
 */
@Data
public class WorkerSignRequest implements Serializable {
    private Long workerId;
    private Long equipmentId;
    private String signTime;
}
