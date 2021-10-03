package com.qf.exception;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 * 自定义异常04
 */
public class UploadSizeOverException extends RuntimeException{
    public UploadSizeOverException() {
    }

    public UploadSizeOverException(String message) {
        super(message);
    }
}
