package com.qf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/22  9:09
 */
//@Configuration  //作为配置类，作用是配置信息
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    配置类设置用户

    /**
     * 认证管理构建器
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = passwordEncoder.encode("123456");
        auth
                .inMemoryAuthentication()   //基于内存的验证管理
                .withUser("java2103")   //认证需要的用户名
                .password(password)     //认证需要的密码
                .roles();       //认证 的角色，方法参数可以为空，必须要写

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
