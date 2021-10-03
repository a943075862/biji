package com.qf.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/30  14:31
 */

@Data
@TableName("tb_user")
@AllArgsConstructor
@NoArgsConstructor
//无视set、get的前缀 及user.setId().setUsername().setPassword()...
@Accessors(chain = true)
public class User implements Serializable {
    //主键注解 设置自增,增加此条指令时不会自动生成mybatisplus的超长id
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    //设置不显示
    @TableField(select = false)
    private String password;
    private String name;
    private Integer age;
    private String email;

}
