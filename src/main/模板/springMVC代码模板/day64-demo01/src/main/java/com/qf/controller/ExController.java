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
@RequestMapping("/ex01")
@Controller
public class ExController {
    @RequestMapping("/e01")
    public String ex01(Integer id){
        try {
            System.out.println("id ==="+id);

        } catch (MyException01 e) {
            e.printStackTrace();
        }catch (MyException02 e) {
            e.printStackTrace();
        }catch (MyException03 e) {
            e.printStackTrace();
        } finally {
        }
        return "success";
    }
    @RequestMapping("/e02")
    public String ex02(Integer id){
        try {
            System.out.println("id ==="+id);

        } catch (MyException01 e) {
            e.printStackTrace();
        }catch (MyException02 e) {
            e.printStackTrace();
        }catch (MyException03 e) {
            e.printStackTrace();
        } finally {
        }
        return "success";
    }
    @RequestMapping("/e03")
    public String ex03(Integer id){
        try {
            System.out.println("id ==="+id);

        } catch (MyException01 e) {
            e.printStackTrace();
        }catch (MyException02 e) {
            e.printStackTrace();
        }catch (MyException03 e) {
            e.printStackTrace();
        } finally {
        }
        return "success";
    }


}
