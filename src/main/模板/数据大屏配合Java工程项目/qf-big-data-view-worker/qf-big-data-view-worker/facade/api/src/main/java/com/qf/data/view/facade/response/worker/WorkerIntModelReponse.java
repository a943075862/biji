package com.qf.data.view.facade.response.worker;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/14  10:10
 */

/**
 * 业务提供者向业务消费者返回的对象
 *          传递的是修改行数，用作控制层判断业务是否完成
 */
@Data
public class WorkerIntModelReponse implements Serializable {
    private int row;

}
