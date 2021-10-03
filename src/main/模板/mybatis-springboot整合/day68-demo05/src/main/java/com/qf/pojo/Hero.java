package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/21  11:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hero {

    private Integer id;
    private String name;
    private Integer forceValue;
    private String addr;
    private String info;
}
