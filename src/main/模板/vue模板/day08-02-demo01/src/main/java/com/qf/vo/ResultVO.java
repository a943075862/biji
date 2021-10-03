package com.qf.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/2  11:43
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private boolean success;
    private String message;
    private Object data;

    public static ResultVO ok(String message,Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        resultVO.setMessage(message);
        resultVO.setData(data);
        return resultVO;
    }
    public static ResultVO ok(String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        resultVO.setMessage(message);
        return resultVO;
    }
    public static ResultVO error(String message,Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(false);
        resultVO.setMessage(message);
        resultVO.setData(data);
        return resultVO;
    }
    public static ResultVO error(String message){
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(false);
        resultVO.setMessage(message);
        return resultVO;
    }


}
