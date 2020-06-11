package com.group12.es.controller;

import com.group12.es.model.User;
import com.group12.es.service.UserRepository;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private RestHighLevelClient client;
    @CrossOrigin(origins = "http://localhost:8081")
    @RequestMapping("/search")
    public List searchTitle(String keyword) throws IOException {
        // 统计查询时间,这里开始
        Instant start = Instant.now();
        // 构造查询条件,使用标准分词器.
        QueryBuilder matchQuery = QueryBuilders.matchQuery("name", keyword).analyzer("standard").operator(Operator.OR);
        // 设置高亮,使用默认的highlighter高亮器
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(matchQuery);
        HighlightBuilder highlightBuilder = new HighlightBuilder()
                .field("name")
                .preTags("<span style=\"color:red;font-weight:bold;font-size:15px;\">")
                .postTags("</span>");
        searchSourceBuilder.highlighter(highlightBuilder);
        // 设置查询字段
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest,RequestOptions.DEFAULT);
        //System.out.println("response:"+response.toString());
        /*
        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.queryStringQuery(keyword).defaultField("name"))
                .withHighlightFields(new HighlightBuilder.Field("name"))
                .build();
         */
        // 返回搜索结果
        SearchHits hits = response.getHits();
        // 统计搜索结束时间
        Instant end = Instant.now();
        System.out.println("共搜索到: "+hits.getTotalHits() + " 条结果" + "," + "共耗时: " + Duration.between(start, end).toMillis()/1000 + " 秒");
        SearchHit[] searchHits = hits.getHits();
        List<User> userList = new ArrayList<>();
        for (SearchHit searchHit:searchHits){
            User user = new User();
            //searchHit.getSourceAsMap().get("name");
            //searchHit.getHighlightFields().get("name");
            //user.setName(searchHit.getHighlightFields().get("name").getFragments());
            // 返回文档的高亮字段
            Text[] text = searchHit.getHighlightFields().get("name").getFragments();
            String hight="";
            if (text != null) {
                for (Text str : text) {
                    hight+=str;
                    System.out.println(str.toString());
                }
            }
            user.setName(hight);
            user.setUserId(searchHit.getSourceAsMap().get("user_id").toString());
            user.setBankCard(searchHit.getSourceAsMap().get("bank_card").toString());
            user.setNation(searchHit.getSourceAsMap().get("nation").toString());
            user.setDepartmentId(searchHit.getSourceAsMap().get("department_id").toString());
            user.setDegree(searchHit.getSourceAsMap().get("degree").toString());
            user.setOrigin(searchHit.getSourceAsMap().get("origin").toString());
            user.setWorkingAge((int)searchHit.getSourceAsMap().get("working_age"));
            user.setIdCard(searchHit.getSourceAsMap().get("id_card").toString());
            user.setOrigin(searchHit.getSourceAsMap().get("origin").toString());
            user.setTitle(searchHit.getSourceAsMap().get("title").toString());
            if (searchHit.getSourceAsMap().get("telephone")!=null){
                user.setTelephone(searchHit.getSourceAsMap().get("telephone").toString());
            }else {
                user.setTelephone("null");
            }
            if (searchHit.getSourceAsMap().get("email")!=null){
                user.setEmail(searchHit.getSourceAsMap().get("email").toString());
            }else {
                user.setEmail("null");
            }
            userList.add(user);
        }

        return userList;
    }
}