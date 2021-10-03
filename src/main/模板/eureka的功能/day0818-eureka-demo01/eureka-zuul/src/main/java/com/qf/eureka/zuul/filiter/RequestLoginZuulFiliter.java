package com.qf.eureka.zuul.filiter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Objects;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/18  18:09
 */
@Component
public class RequestLoginZuulFiliter extends ZuulFilter {
    /**
     * 指明过滤器优先级
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }
    /**
     * 指明过滤器优先级
     * @return
     */
    @Override
    public int filterOrder() {
        return 2;
    }
    /**
     * 是否执行过滤,如果有多个过滤器的，这个地方要设置成false，最后一个过滤器设置成true
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    /**
     * 执行具体的业务：做一个计数器限流，限制后端服务的访问数5个，访问数谁来维护
     *  重点关注：放行和不放行
     * @return
     * @throws ZuulException
     */

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        //获取请求
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        //请求中获取cookies
        Cookie[] cookies = request.getCookies();
        String loginToken="";
        //如果cookie中没有值，则提示去登陆
        if (Objects.isNull(cookies)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(200);
            String message="please to login";
            context.setResponseBody(message);
            return null;
        }
        //遍历cookies
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login_token")){
                //获取cookie中存入的login_token值，赋值给logintoken
                loginToken=cookie.getValue();
                break;
            }
        }
        //判断logintoken值是否与redis中值是否一致，若不一致则提示登陆
        if (StringUtils.isBlank(loginToken)){
            context.setSendZuulResponse(false);
            context.setResponseStatusCode(200);
            context.setResponseBody("please to login");
            return null;
        }else {
            //如果一致则跳转需求，这里只要有值就跳转
            context.setSendZuulResponse(true);
            context.setResponseStatusCode(200);
            return null;
        }



    }
}
