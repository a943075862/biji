package com.qf.resolver;

import com.qf.exception.MyException01;
import com.qf.exception.UploadSizeOverException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 * 异常解析器
 */
public class MyExpectionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if (ex instanceof MyException01){
            modelAndView.setViewName("redirect:/error01.jsp");
        }else if (ex instanceof SQLException){
            modelAndView.setViewName("redirect:/error02.jsp");
        }else if (ex instanceof NullPointerException){
            modelAndView.setViewName("redirect:/error03.jsp");
        }else if (ex instanceof UploadSizeOverException){
            modelAndView.setViewName("redirect:/uploaderror.jsp");
        }

        return modelAndView;
    }
}
