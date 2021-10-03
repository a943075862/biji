package com.qf.java2103.ssm.resultVO;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/06/23
 */
@Component
public class ResultVO {
    /**
     * 储存结果的对象
     */
    //储存String类型的结果
    private String message;
    //储存集合的结果
    private Object data;
    //储存布尔类型的结果
    private boolean success;

    public ResultVO() {
    }

    public ResultVO(String message, Object data, boolean success) {
        this.message = message;
        this.data = data;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "ResultVO{" +
                "message='" + message + '\'' +
                ", data=" + data +
                ", success=" + success +
                '}';
    }
}
