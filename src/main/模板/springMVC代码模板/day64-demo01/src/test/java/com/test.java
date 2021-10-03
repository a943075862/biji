package com;

import org.junit.Test;

import java.util.Date;
import java.util.UUID;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */
public class test {
    @Test
    public void getTest(){
        UUID uuid = UUID.randomUUID();
        String string = uuid.toString();
        String s = string.replaceAll("-", "");
        System.out.println("s = " + s);
    }
    @Test
    public void getsource(){
//        10.31.162.8
        String a= "10.31.162.";
        for (int i = 1; i <=255; i++) {
            System.out.println(a+i);
        }
    }
    @Test
    public void getsource02(){
        Date date = new Date();
        date.setTime(System.currentTimeMillis());
        System.out.println("date = " + date);
    }
}
