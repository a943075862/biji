package com.qf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */
@Configuration
@PropertySource("classpath:druid.properties")
@MapperScan("com.qf.mapper")
public class UserConfig01 {


}
