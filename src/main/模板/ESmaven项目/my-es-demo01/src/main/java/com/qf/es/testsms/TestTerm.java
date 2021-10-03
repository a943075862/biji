package com.qf.es.testsms;

import com.alibaba.fastjson.JSONObject;
import com.qf.es.pojo.SmsLogs;
import com.qf.es.utils.ESUtil;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.mapper.ObjectMapper;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author xiobb
 * @version V1.0
 * @date 2021/8/31  19:18
 */

/**
 * 测试查询
 *
 */
public class TestTerm {
    String index = "sms-logs-index";
    String type = "sms-logs-type";

    /**
     * 测试term
     * @throws IOException
     */
    @Test
    public void testTerm() throws IOException {
        //创建一个查询的request对象
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        //封装查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(0);
        builder.size(5);
        TermQueryBuilder query = QueryBuilders.termQuery("province", "北京");
        request.source(builder);
        RestHighLevelClient client = ESUtil.getClient();
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        SearchHit[] hits1 = hits.getHits();
        ArrayList<SmsLogs> smsLogs = new ArrayList<>();
        for (SearchHit documentFields : hits1) {
            String json = documentFields.getSourceAsString();
            SmsLogs smsLogs1 = JSONObject.parseObject(json, SmsLogs.class);
            smsLogs.add(smsLogs1);
        }
        System.out.println("smsLogs = " + smsLogs);
    }

    /**
     * 测试terms
     * @throws IOException
     */
     @Test
    public void testTerms() throws IOException {
        //创建一个查询的request对象
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        //封装查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.from(0);
        builder.size(5);
        QueryBuilder query = QueryBuilders.termsQuery("province", "北京","山西");
        request.source(builder);
        RestHighLevelClient client = ESUtil.getClient();
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        SearchHit[] hits1 = hits.getHits();
        ArrayList<SmsLogs> smsLogs = new ArrayList<>();
        for (SearchHit documentFields : hits1) {
            String json = documentFields.getSourceAsString();
            SmsLogs smsLogs1 = JSONObject.parseObject(json, SmsLogs.class);
            smsLogs.add(smsLogs1);
        }
         for (SmsLogs smsLog : smsLogs) {
             System.out.println("smsLog = " + smsLog);
         }
    }

    /**
     * 测试match All
     * @throws IOException
     */
     @Test
    public void testMatchAll() throws IOException {
         //创建一个查询的request对象
         SearchRequest request = new SearchRequest(index);
         request.types(type);
         SearchSourceBuilder builder = new SearchSourceBuilder();
         MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
         builder.query(queryBuilder);
         request.source(builder);

         RestHighLevelClient client = ESUtil.getClient();
         SearchResponse response = client.search(request, RequestOptions.DEFAULT);
         SearchHits hits = response.getHits();
         SearchHit[] hits1 = hits.getHits();
         ArrayList<SmsLogs> smsLogs = new ArrayList<>();
         for (SearchHit documentFields : hits1) {
             String json = documentFields.getSourceAsString();
             SmsLogs smsLogs1 = JSONObject.parseObject(json, SmsLogs.class);
             smsLogs.add(smsLogs1);
         }
         for (SmsLogs smsLog : smsLogs) {
             System.out.println("smsLog = " + smsLog);
         }
     }

    /**
     * 测试match
     * @throws IOException
     */
         @Test
    public void testMatch() throws IOException {
        //创建一个查询的request对象
        SearchRequest request = new SearchRequest(index);
        request.types(type);
         SearchSourceBuilder builder = new SearchSourceBuilder();
             MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("smsContent", "收货安装");
             builder.query(queryBuilder);
         request.source(builder);

         RestHighLevelClient client = ESUtil.getClient();
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        SearchHit[] hits1 = hits.getHits();
        ArrayList<SmsLogs> smsLogs = new ArrayList<>();
        for (SearchHit documentFields : hits1) {
            String json = documentFields.getSourceAsString();
            SmsLogs smsLogs1 = JSONObject.parseObject(json, SmsLogs.class);
            smsLogs.add(smsLogs1);
        }
         for (SmsLogs smsLog : smsLogs) {
             System.out.println("smsLog = " + smsLog);
         }
    }

    /**
     * 测试布尔match
     * @throws IOException
     */
    @Test
    public void testMatchBool() throws IOException {
        //创建一个查询的request对象
        SearchRequest request = new SearchRequest(index);
        request.types(type);
         SearchSourceBuilder builder = new SearchSourceBuilder();
             MatchQueryBuilder queryBuilder = QueryBuilders.matchQuery("smsContent","中国 健康").operator(Operator.OR);
             builder.query(queryBuilder);
         request.source(builder);

         RestHighLevelClient client = ESUtil.getClient();
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        SearchHit[] hits1 = hits.getHits();
        ArrayList<SmsLogs> smsLogs = new ArrayList<>();
        for (SearchHit documentFields : hits1) {
            String json = documentFields.getSourceAsString();
            SmsLogs smsLogs1 = JSONObject.parseObject(json, SmsLogs.class);
            smsLogs.add(smsLogs1);
        }
         for (SmsLogs smsLog : smsLogs) {
             System.out.println("smsLog = " + smsLog);
         }
    }

    /**
     * 测试multi——match
     * @throws IOException
     */
    @Test
    public void testMultiMatch() throws IOException {
        //创建一个查询的request对象
        SearchRequest request = new SearchRequest(index);
        request.types(type);
         SearchSourceBuilder builder = new SearchSourceBuilder();
        MultiMatchQueryBuilder builder1 = new MultiMatchQueryBuilder("北京","province","smsContent");
        builder.query(builder1);
         request.source(builder);

         RestHighLevelClient client = ESUtil.getClient();
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        SearchHit[] hits1 = hits.getHits();
        ArrayList<SmsLogs> smsLogs = new ArrayList<>();
        for (SearchHit documentFields : hits1) {
            String json = documentFields.getSourceAsString();
            SmsLogs smsLogs1 = JSONObject.parseObject(json, SmsLogs.class);
            smsLogs.add(smsLogs1);
        }
         for (SmsLogs smsLog : smsLogs) {
             System.out.println("smsLog = " + smsLog);
         }
    }

    /**
     * 测试scroll查询
     */
    @Test
    public void testscroll() throws IOException {
        SearchRequest request = new SearchRequest(index);
        request.types(type);
        //设置缓冲区的存活时间
        request.scroll(TimeValue.timeValueMinutes(1L));
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(QueryBuilders.matchAllQuery());
        builder.size(5);
        request.source(builder);

        RestHighLevelClient client = ESUtil.getClient();
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        String scrollId = response.getScrollId();

        //========第一次查询===========
        List<SmsLogs> smsLogsList = getSmsLogs(response);
        System.out.println(smsLogsList.size()+":"+smsLogsList);

        while(true) {
            //====之后的每一次======
            SearchScrollRequest searchScrollRequest = new SearchScrollRequest(scrollId);
            //续命
            searchScrollRequest.scroll(TimeValue.timeValueMinutes(1));
            //执行scroll查询
            SearchResponse scrollResponse = client.scroll(searchScrollRequest, RequestOptions.DEFAULT);
            List<SmsLogs> list = getSmsLogs(scrollResponse);
            if (Objects.isNull(list) || list.size() == 0) {
                break;
            }
            System.out.println("=========================");
            System.out.println(list.size() + ":" + list);

        }
    }
    private List<SmsLogs> getSmsLogs(SearchResponse response) throws com.fasterxml.jackson.core.JsonProcessingException {
        //5.解析查询结果
        List<SmsLogs> smsLogsList = new ArrayList<>();
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            String json = hit.getSourceAsString();
            SmsLogs smsLogs = JSONObject.parseObject(json, SmsLogs.class);
            smsLogsList.add(smsLogs);
        }
        return smsLogsList;
    }

}
