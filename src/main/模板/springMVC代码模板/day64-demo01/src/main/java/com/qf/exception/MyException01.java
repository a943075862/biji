package com.qf.exception;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 * 自定义异常01
 */
public class MyException01 extends RuntimeException {
    public MyException01() {
    }

    public MyException01(String message) {
        super(message);
    }
}
