package com.qf.data.view.facade.request.worker;

import lombok.Data;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/13  20:17
 */

/**
 * controller层向service层传输的对象
 *          消费者向提供者传递的对象
 *          这里传递的是工人的id
 */
@Data
public class WorkerModelRequest implements Serializable {
      private Long id;
}
