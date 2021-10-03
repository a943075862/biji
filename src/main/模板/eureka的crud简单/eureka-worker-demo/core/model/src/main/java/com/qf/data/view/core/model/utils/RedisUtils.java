package com.qf.data.view.core.model.utils;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/16  12:23
 */
public class RedisUtils {

    public static String getRedisKey(String profix,String context){
        return new StringBuffer().append(profix).append(":").append(context).toString();
    }
}
