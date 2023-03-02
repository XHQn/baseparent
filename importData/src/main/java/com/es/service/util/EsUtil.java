package com.es.service.util;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.UUIDs;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class EsUtil {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 批量插入数据
     * @param idxName
     * @param list
     */
    public void insertBatch(String idxName, List<Map<String,Object>> list) throws Exception {

        if(list != null && list.size() > 0){
            BulkRequest bulkRequest = new BulkRequest();
            bulkRequest.timeout("10s");
            for (int i = 0; i < list.size(); i++) {
                // 批量更新和删除，在这里修改相应请求
                bulkRequest.add(
                        // 这里是数据信息
                        new IndexRequest(idxName)
                                .id(""+(i + 1)) // 没有设置id 会自定生成一个随机id
                                .source(JSON.toJSONString(list.get(i)),XContentType.JSON)
                );
            }
            BulkResponse bulk = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
            System.out.println(bulk.status());// ok
        }else{
            System.out.println("没有数据被插入ES，传入的集合为空。");
        }
    }
}
