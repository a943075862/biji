package com.qf.config;


import com.qf.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/22  9:09
 */
@Configuration  //作为配置类，作用是配置信息
public class SecurityConfig2 extends WebSecurityConfigurerAdapter {
//    配置类设置用户
    @Autowired
    MyUserDetailsService myUserDetailsService;
    /**
     * 认证管理构建器
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 认证调用myuserDEtailsService来完成
        auth.userDetailsService(myUserDetailsService);
    }

    /**
     * 定义登录，退出，放行等操作
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/403.html");
            http
                    //开始配置自定义表单
                    .formLogin()
                    //配置登录页
                    .loginPage("/login.html")
                    .loginProcessingUrl("/user/login")
                    /* 默认的用户名和密码名称为username和password
                    自定义用户名和密码的名称必须在这里配置
                    .usernameParameter("uname")
                    .passwordParameter("pwd")
                    登录成功，可以配置去默认的资源，如果直接访问登录页，
                    没有去其他资源，那么登录成功后会去访问默认资源
                    如果访问其他权限没有资源，会跳回登录页，那么登录成功后，就会去之前访问的资源
                    */
                    .defaultSuccessUrl("/index.html")
                    //经过上述配置之后，就放行
                    .permitAll()
            .and()
                    //释放指定资源
                    .authorizeRequests()
                    //
                    .antMatchers("/test1/*")
                    //方向
                    .permitAll()
                    .antMatchers("/index.html")
                    .hasAnyRole("student","teacher").anyRequest().authenticated()
                    .and().csrf().disable();
            /*.and()
                    //开始认证请求
                    .authorizeRequests()
                    //所有请求
                    .anyRequest()
                    //经过认证
                    .authenticated()

            .and()
                    //关闭csrf
                    .csrf().disable();*/
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
