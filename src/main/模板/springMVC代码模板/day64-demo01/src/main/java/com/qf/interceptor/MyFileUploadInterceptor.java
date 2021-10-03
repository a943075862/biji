package com.qf.interceptor;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

import com.qf.exception.UploadSizeOverException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 如果文件超出1MB，报异常，异常被自定义的异常解析器处理，重定向到uploadError页面，提示上传文件过大
 */

/**
 * 拦截器
 */
public class MyFileUploadInterceptor implements HandlerInterceptor {
    private long maxSize=102400;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //判断是否文件上传，是否是文件上传
        if(request!=null && ServletFileUpload.isMultipartContent(request)) {
            //判断文件大小是否合适
            ServletRequestContext ctx = new ServletRequestContext(request);
            //获取上传文件尺寸大小
            long requestSize = ctx.contentLength();
            if (requestSize > maxSize) {
                //当上传文件大小超过指定大小限制后，模拟抛出UploadSizeOverException异常
                throw new UploadSizeOverException("error");
            }
        }
        return true;
    }

    public long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(long maxSize) {
        this.maxSize = maxSize;
    }


}
