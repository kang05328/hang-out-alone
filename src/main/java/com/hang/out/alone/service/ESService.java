package com.hang.out.alone.service;

import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Log4j2
public class ESService {

    private final RestHighLevelClient restHighLevelClient;
    private final DataService dataService;

    public ESService(final RestHighLevelClient restHighLevelClient, final DataService dataService) {
        this.restHighLevelClient = restHighLevelClient;
        this.dataService = dataService;
    }

    // TODO : create index, get document, update document, find 등 구현 필요.

    public void addDocument(Map<String, Object> objectMap) {
        try {
            // TODO : index 이름 변경

            String jsonString = dataService.culturePlace();

            IndexRequest indexRequest = new IndexRequest("event_place").id("1")
                    .source(jsonString, XContentType.JSON);

            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            log.info(indexResponse.status());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
