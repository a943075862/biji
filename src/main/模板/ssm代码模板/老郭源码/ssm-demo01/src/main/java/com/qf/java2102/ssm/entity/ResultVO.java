package com.qf.java2102.ssm.entity;

/**
 * 通过结果类
 * @param <T>
 * @author ghy
 */
public class ResultVO<T> {

    /**
     * 是否成功
     */
    private Boolean success;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应的附加数据
     */
    private T data;

    public ResultVO() {}

    public ResultVO(Boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public ResultVO(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ResultVO(String message) {
        this.message = message;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 成功
     * @param message
     * @param data
     * @return
     */
    public static <T> ResultVO<T> ok(String message, T data){
        return new ResultVO(true, message, data);
    }

    /**
     * 成功
     * @param message
     * @return
     */
    public static <T> ResultVO<T> ok(String message){
        return new ResultVO(true, message);
    }

    /**
     * 失败
     * @param message
     * @param data
     * @return
     */
    public static <T> ResultVO<T>  error(String message, T data){
        return new ResultVO(false, message, data);
    }

    /**
     * 失败
     * @param message
     * @return
     */
    public static <T> ResultVO<T> error(String message){
        return new ResultVO(false, message);
    }
}
