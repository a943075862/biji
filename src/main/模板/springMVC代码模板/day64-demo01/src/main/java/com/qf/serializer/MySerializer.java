package com.qf.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/07/14
 */

/**
 * 自定义小数的取舍方式
 */
public class MySerializer extends JsonSerializer<Double> {
    @Override
    public void serialize(Double value, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        //四舍五入后
        String number= BigDecimal.valueOf(value).setScale(2,BigDecimal.ROUND_HALF_UP).toString();
        //输出 四舍五入之后的值
        jsonGenerator.writeNumber(number);

    }
}
