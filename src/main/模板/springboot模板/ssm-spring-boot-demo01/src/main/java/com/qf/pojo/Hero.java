package com.qf.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Hero {
    private Integer id;
    private String name;
    private Integer forceValue;
    private String addr;
    private String info;
}
