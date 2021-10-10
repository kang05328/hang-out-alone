package com.hang.out.alone.service;

import lombok.extern.log4j.Log4j2;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class ESService {

    private final RestHighLevelClient restHighLevelClient;

    public ESService(final RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }

    // TODO : create index, get document, update document, find 등 구현 필요.

    public void addDocument(String jsonString, String indexName, String documentId) {
        try {
            IndexRequest indexRequest = new IndexRequest(indexName).id(documentId)
                    .source(jsonString, XContentType.JSON);

            IndexResponse indexResponse = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            log.info(indexResponse.status());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getData(String indexName, String documentId) {
        try {
            GetRequest getRequest = new GetRequest(indexName, documentId);
            GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            String message = getResponse.getSourceAsString();
            return message;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
