package com.hang.out.alone.service;

import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ESService {

    private final RestHighLevelClient restHighLevelClient;

    public ESService(final RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    public void addDocument(Map<String, Object> objectMap) {
        try {
            // TODO : bulk request 로 변경.
            // TODO : index 이름 변경
            IndexRequest indexRequest = new IndexRequest("test").id("1")
                    .source(objectMap);

            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
