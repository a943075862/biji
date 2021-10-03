package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/15
 */
@RequestMapping("/checkCaptcha")
@Controller
public class CaptchaController {
    /**
     * 验证验证码是否正确
     * @param captcha
     * @param session
     * @return
     */
    @RequestMapping("/check01")
    public String check01(String captcha, HttpSession session){
        //获取存在session中的验证码
        String capCode = (String) session.getAttribute("captcha");
        //判断验证码是否存在   若出现取不到session中的验证码   在配置文件中将验证码存到session中
        System.out.println("capCode = " + capCode);
        //判断
        if (captcha.equalsIgnoreCase(capCode)){
            return "index";
        }

        return "error01";
    }
}
