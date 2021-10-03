package com.qf.exception;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 * 自定义异常02
 */
public class MyException03 extends RuntimeException {
    public MyException03() {
    }

    public MyException03(String message) {
        super(message);
    }
}
