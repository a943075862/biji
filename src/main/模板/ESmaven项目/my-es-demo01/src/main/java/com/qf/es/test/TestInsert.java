package com.qf.es.test;

import com.alibaba.fastjson.JSONObject;
import com.qf.es.pojo.Book;
import com.qf.es.utils.ESUtil;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Test;

import java.io.IOException;
import java.util.Objects;


/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/31  17:29
 */
public class TestInsert {
    @Test
    public void testInsert() throws IOException {
        //获得一个客户端
        RestHighLevelClient client = ESUtil.getClient();
        //2.指明索引和类型
        String index = "book_pro";
        String type = "it";
        //准备数据
        Book book = new Book();
        book.setId(1001L);
        book.setName("小说");
        book.setAuthor("小红");
        //转换成json
        String json = JSONObject.toJSONString(book);
        //准备一个request对象
        IndexRequest request = new IndexRequest(index, type, book.getId().toString());
        request.source(json, XContentType.JSON);
        //用client去发送一个request-restful得到响应结果
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println("response = " + response.getResult());
    }
    @Test
    public void testUpdate() throws IOException {
        //获得一个客户端
        RestHighLevelClient client = ESUtil.getClient();
        //2.指明索引和类型
        String index = "book_pro";
        String type = "it";
        //准备数据
        Book book = new Book();
        book.setId(1001L);
        book.setName("小说1");
        book.setAuthor("小红1");
        //转换成json
        String json = JSONObject.toJSONString(book);
        //准备一个request对象
//        IndexRequest request = new IndexRequest(index, type, book.getId().toString());
//        request.source(json, XContentType.JSON);
        UpdateRequest request = new UpdateRequest(index,type,book.getId().toString());
        request.doc(json,XContentType.JSON);
        //用client去发送一个request-restful得到响应结果
//        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
//        System.out.println("response = " + response.getResult());
        UpdateResponse response = client.update(request, RequestOptions.DEFAULT);
        System.out.println("response = " + response.getResult());
    }
    @Test
    public void testDelete() throws IOException {
        //获得一个客户端
        RestHighLevelClient client = ESUtil.getClient();
        //2.指明索引和类型
        String index = "book_pro";
        String type = "it";

        //准备一个request对象
        DeleteRequest request = new DeleteRequest(index,type,"1001");
        //用client去发送一个request-restful得到响应结果
        DeleteResponse response = client.delete(request, RequestOptions.DEFAULT);
        System.out.println("response = " + response.getResult());
    }



}
