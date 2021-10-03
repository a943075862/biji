package com.qf.exception;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 * 自定义异常02
 */
public class MyException02 extends RuntimeException {
    public MyException02() {
    }

    public MyException02(String message) {
        super(message);
    }
}
