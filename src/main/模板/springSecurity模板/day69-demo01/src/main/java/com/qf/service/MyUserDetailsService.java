package com.qf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qf.mapper.UserInfoMapper;
import com.qf.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/22  9:28
 */
@Component
public class MyUserDetailsService implements UserDetailsService {
   @Autowired
   private PasswordEncoder passwordEncoder;

   @Autowired
   private UserInfoMapper userInfoMapper;
    @Override
    public UserDetails loadUserByUsername(String username) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (userInfo==null){
            return null;
        }
        Collection< ? extends GrantedAuthority> authorities =null;
        authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_student"); //为空为不限定权限
        return new User(username,userInfo.getPassword(),authorities);

      /*  //只有用户名是tom且密码是123456才能登录成功
        if ("tom".equals(username)){
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(""); //为空为不限定权限
            //是TOM，尝试登录
            System.out.println("登录的是tom");
            return new User(username,passwordEncoder.encode("123456"),authorities);

        }
        System.out.println("登录的人不是tom，登录失败");
        return null;*/
    }


    public static void main(String[] args) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i <=5 ; i++) {
            System.out.println(passwordEncoder.encode("123456"));
        }
        //比对密码
        String pwd="$2a$10$AJ1DbWAWsjDxKyUzlRmxZuwHrckTjvL8X67QaLpN3EKYoKlmvatnW";
        boolean matches = passwordEncoder.matches("123456", pwd);
        System.out.println("matches = " + matches);
    }
}
