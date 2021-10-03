package com.qf.pojo;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/01
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 人实体类
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class People {
    //用户id
    private String id;
    //用户名
    private String  username;
    //年龄
    private int age;
    //性别
    private String gender;
    //地址
    private String addr;
    //信息
    private String info;
}
