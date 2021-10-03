package com.qf.controller;

import com.qf.exception.MyException01;
import com.qf.exception.MyException02;
import com.qf.exception.MyException03;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */
@RequestMapping("/ex02")
@Controller
public class ExController02 {
    @RequestMapping("/e01")
    public String ex01(Integer id){
       if (id %5==0){
           throw new MyException01("id不能是5的倍数");
       }else if (id % 3==0){
           throw new MyException02("id不能是3的倍数");
       }
        return "success";
    }


}
