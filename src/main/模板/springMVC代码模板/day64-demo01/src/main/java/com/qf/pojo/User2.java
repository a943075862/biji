package com.qf.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qf.serializer.MySerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User2 {

    private Integer id;
    //属性别名
    @JsonProperty("userName")
    private String username;
    //忽略指定项
    @JsonIgnore
    private String password;
    //格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registerTime;
    //无数据则忽略，如果有对象但对象是空会显示
    @JsonInclude(JsonInclude.Include.NON_NULL)
    //如果有对象但对象是空会显示，如果无数据也不显示
//    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<String> hobby;
    //自定义格式化
//    @JsonSerialize(using = MySerializer.class)
    @JsonSerialize(using = MySerializer.class)
    private Double salary;

}
