package com.es;

import com.alibaba.fastjson.JSON;
import com.es.config.EsConfig;
import com.es.config.User;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;

@SpringBootTest(classes = {EsConfig.class})
public class EsApiApplicationTests {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    //测试索引的创建 Request
    @Test
    void testCreateIndex() throws IOException {
        //创建索引请求
        CreateIndexRequest request = new CreateIndexRequest("rainhey_index");
        //客户端执行请求
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse);
    }
    //测试获取索引,判断是否存在
    @Test
    void testExistIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("rainhey_index");
        boolean exists = restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }
    //测试删除索引
    @Test
    void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("rainhey_index");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(delete.isAcknowledged());   //输出是否设置成功
    }
    //测试创建文档
    @Test
    void testAddDOcument() throws IOException {
        //创建对象
        User user = new User("rainhey", 3);
        //创建请求
        IndexRequest request = new IndexRequest("rainhey_index");
        //规则
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
             //request.timeout("1");
        //将数据放入请求
        IndexRequest source = request.source(JSON.toJSONString(user), XContentType.JSON);
        //客户端发送请求,获取响应结果
        IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        System.out.println(indexResponse.toString());
        System.out.println(indexResponse.status());
    }
    //获取文档 判断是否存在 get index/doc/1
    @Test
    public void testIsExist() throws IOException {
        GetRequest request = new GetRequest("rainhey_index","1");
        //不获取_source的上下文
        request.fetchSourceContext(new FetchSourceContext(false));
        request.storedFields("_none_");
        boolean exists = restHighLevelClient.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }
    //获得文档信息
    @Test
    public void testGetDocument() throws IOException {
        GetRequest request = new GetRequest("rainhey_index","1");
        GetResponse documentFields = restHighLevelClient.get(request, RequestOptions.DEFAULT);
        System.out.println(documentFields.getSourceAsString());
        System.out.println(documentFields);
    }
    //更新文档
    @Test
    public void testUpdateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest("rainhey_index", "1");
        User user = new User("rao",11);
        request.doc(JSON.toJSONString(user), XContentType.JSON);
        UpdateResponse response = restHighLevelClient.update(request, RequestOptions.DEFAULT);
        System.out.println(response.status()); // OK
    }
    //删除文档
    @Test
    public void testDeleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest("rainhey_index", "1");
        request.timeout("1s");
        DeleteResponse response = restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        System.out.println(response.status());// OK
    }

    // 查询
    @Test
    public void testSearch() throws IOException {
        SearchRequest request = new SearchRequest("rainhey_index");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // 精确查询
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "rainhey");
        searchSourceBuilder.query(termQueryBuilder);
        // 分页
        //searchSourceBuilder.from();
        //searchSourceBuilder.size();

        // 设置高亮
        //searchSourceBuilder.highlighter(new HighlightBuilder());

        // 添加条件到请求
        request.source(searchSourceBuilder);

        //执行请求
        SearchResponse searchResponse = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
        System.out.println(JSON.toJSONString(hits));
        for (SearchHit documentFileds: hits.getHits()){
            System.out.println(documentFileds.getSourceAsMap());
        }
    }


    //批量导入数据
    @Test
    public void testBulk() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("liuyou-1",1));
        users.add(new User("liuyou-2",2));
        users.add(new User("liuyou-3",3));
        users.add(new User("liuyou-4",4));
        users.add(new User("liuyou-5",5));
        users.add(new User("liuyou-6",6));
        for (int i = 0; i < users.size(); i++) {
            // 批量更新和删除，在这里修改相应请求
            bulkRequest.add(
                    // 这里是数据信息
                    new IndexRequest("bulk")
                            .id(""+(i + 1)) // 没有设置id 会自定生成一个随机id
                            .source(JSON.toJSONString(users.get(i)),XContentType.JSON)
            );
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.status());// ok
    }


    //批量导入zmm数据
    @Test
    public void zmmBulk() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.timeout("10s");
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("liuyou-1",1));
        users.add(new User("liuyou-2",2));
        users.add(new User("liuyou-3",3));
        users.add(new User("liuyou-4",4));
        users.add(new User("liuyou-5",5));
        users.add(new User("liuyou-6",6));
        for (int i = 0; i < users.size(); i++) {
            // 批量更新和删除，在这里修改相应请求
            bulkRequest.add(
                    // 这里是数据信息
                    new IndexRequest("bulk")
                            .id(""+(i + 1)) // 没有设置id 会自定生成一个随机id
                            .source(JSON.toJSONString(users.get(i)),XContentType.JSON)
            );
        }
        BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulk.status());// ok
    }

    // 查询
    @Test
    public void zmmSearch() throws IOException {
        SearchRequest request = new SearchRequest("zmm202211");
        //构建搜索条件
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        //具体条件
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        // 3.设置boolQueryBuilder条件
        MatchPhraseQueryBuilder matchPhraseQueryBuilder = QueryBuilders.matchPhraseQuery("companyName", "欧亚热力");
//        MatchPhraseQueryBuilder matchPhraseQueryBuilder2 = QueryBuilders
//                .matchPhraseQuery("key_word", "湖人");
        // 子boolQueryBuilder条件条件，用来表示查询条件or的关系
        BoolQueryBuilder childBoolQueryBuilder = new BoolQueryBuilder()
                .should(matchPhraseQueryBuilder);
//                .should(matchPhraseQueryBuilder2);
        // 4.添加查询条件到boolQueryBuilder中
        boolQueryBuilder.must(childBoolQueryBuilder);
        searchSourceBuilder.query(boolQueryBuilder);
        // 分页
        //searchSourceBuilder.from();
        //searchSourceBuilder.size();
        // 设置高亮
        //searchSourceBuilder.highlighter(new HighlightBuilder());

        // 添加条件到请求
        request.source(searchSourceBuilder);

        //执行请求
        SearchResponse searchResponse = restHighLevelClient.search(request, RequestOptions.DEFAULT);
        SearchHits hits = searchResponse.getHits();
//        System.out.println(JSON.toJSONString(hits));
        for (SearchHit documentFileds: hits.getHits()){
            System.out.println(documentFileds.getSourceAsMap());
        }
    }


}