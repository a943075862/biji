package com.qf.pojo;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/2  11:43
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("users")
public class User {

    private String userName;
    private String password;
    private String name;
    private String age;
    private String email;

    private Integer userStatus;
    private Date createTime;
    private Date updateTime;


}
