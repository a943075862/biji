package com.qf.serializer;

import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 * 格式化小数输出
 */
public class MySerializable implements ObjectSerializer {




    @Override
    public void write(JSONSerializer jsonSerializer, Object object, Object o1, Type type, int i) throws IOException {
        Double value= (Double) object;  //salary属性值，把object转为doublie类型
        String number= BigDecimal.valueOf(value).setScale(2,BigDecimal.ROUND_HALF_UP).toString();//设置四舍五入，小数点后两位
        String text = number+"元";        //在salary后面拼接“"元"”
        jsonSerializer.write(text);     //输出拼接后的内容
    }
}
