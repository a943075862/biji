package com.qf.eureka.zuul.fallback;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/18  17:09
 */
@Component
public class MyZuulFallback implements FallbackProvider {
    @Override
    public String getRoute() {
//        return null;  //配置指定业务设置熔断器，如果为空则配置所有业务
        return "WORKER-CONSUMER";   //设置指定业务的熔断器
    }

    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            /**
             * 响应行类型
             * @return
             * @throws IOException
             */
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            /**
             * 设置响应码
             * @return
             * @throws IOException
             */
            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            /**
             * 设置响应信息
             * @return
             * @throws IOException
             */
            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.getReasonPhrase();
            }

            @Override
            public void close() {

            }

            /**
             * 放入请求体
             *      设置传回对象
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                ObjectMapper objectMapper = new ObjectMapper();
                HashMap<String, Object> map = new HashMap<>();
                map.put("code",1000);
                map.put("message","success");
                map.put("data","网络连接错误，请检查网络");
                String json = objectMapper.writeValueAsString(map);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
                return byteArrayInputStream;
            }

            /**
             * 设置传入对象的类型
             *      设置为json对象
             * @return
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}
