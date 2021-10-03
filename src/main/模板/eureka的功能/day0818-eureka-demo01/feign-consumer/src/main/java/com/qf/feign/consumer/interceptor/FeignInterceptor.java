package com.qf.feign.consumer.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Map;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/18  11:43
 */

/**
 * feign执行操作之前先经过拦截器
 */
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Cookie[] cookies = request.getCookies();
        String loginToken="";
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_token")){
                loginToken=cookie.getValue();
                break;
            }
        }
        if (StringUtils.isNotBlank(loginToken)){
            requestTemplate.header(HttpHeaders.COOKIE,new StringBuffer().append("login_token").append("=").append(loginToken).toString());
        }

    }
}
