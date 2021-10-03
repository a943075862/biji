package com.qf.security;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/7/22  9:23
 */
public interface UserDetailsService {
    /**
     * 认证的身份接口
     */
    UserDetails loadUserByUsername(String username);
}
