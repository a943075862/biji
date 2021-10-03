package com.qf.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.qf.serializer.MySerializable;
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
public class User3 {

    private Integer id;
    //属性别名
    @JsonProperty("userName")
    private String username;
    //忽略属性
    @JsonIgnore
    private String password;
    //日期格式化
    @JSONField(format="yyyy/MM/dd")
    private Date registerTime;
    //忽略优化
    @JSONField(serialzeFeatures = SerializerFeature.WriteMapNullValue)
    private List<String> hobby;
    //自定义格式化
    @JSONField(serializeUsing = MySerializable.class)
    private Double salary;

}
