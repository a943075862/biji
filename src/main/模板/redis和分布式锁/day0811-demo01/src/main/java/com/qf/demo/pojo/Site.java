package com.qf.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/11  19:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Site implements Serializable {
    private Long id;
    private String name;

}
