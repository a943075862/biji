package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    //属性别名
    @JsonProperty("userName")
    private String username;
    //忽略属性
    @JsonIgnore
    private String password;
    //格式化属性，当后端识别到名称但是格式对应不上会报400错误
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registerTime;

}
