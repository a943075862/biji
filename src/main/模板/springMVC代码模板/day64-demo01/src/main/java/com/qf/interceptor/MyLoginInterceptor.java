package com.qf.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 *  拦截器
 */
public class MyLoginInterceptor implements HandlerInterceptor {
    /**
     * 请求到达之前处理
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //判断session中的数据是否合法
        if (session.getAttribute("isLogin")!=null){
            //验证成功 执行后面的handler
            return true;
        }
        //转重定向到登录页面
        response.sendRedirect(request.getContextPath()+"/login.jsp");
        System.out.println("");
        return false;
    }

    /**
     * 请求到达之后处理
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("到达之后postHandle");

    }

    /**
     * 视图加载之后处理
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");

    }
}
