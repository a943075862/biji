package com.qf.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.test.context.ContextConfiguration;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/12
 */
@ContextConfiguration
@MapperScan("com.qf.mapper")
public class UserConfig {
}
