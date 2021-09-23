package com.hang.out.alone.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.nio.charset.Charset;

@Service
@Log4j2
public class DataService {
    // TODO : 자주 변하는 데이터는 아니라서, 하루 한번이나 배치형식으로 스케줄링해서 가져오도록 한다.
    private final String host;
    private final int port;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public DataService(@Value("${openapi.host}") final String host,
                           @Value("${openapi.port}") final int port,
                           final RestTemplate restTemplate,
                           final ObjectMapper objectMapper) {
        this.host = host;
        this.port = port;
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    //TODO : 에러로그
    public String cultureEvent() {
        // TODO : api key 값 분리
        // TODO : 가져오는 범위 페이징 처리
        String path = String.format("/6c796757516b616e373163454f6646/json/culturalEventInfo/1/1000");
        return request(path);
        // TODO : 데이터 파싱 필요 String to Json
    }

    public String culturePlace() {
        // TODO : api key 값 분리
        // TODO : 가져오는 범위 페이징 처리
        String path = String.format("/7a6c5a77616b616e34354d4b447664/json/SearchCulturalFacilitiesAddressService/1/1000");
        return request(path);
        // TODO : 데이터 파싱 필요 String to Json
        // return objectMapper.readValue(Objects.requireNonNull(result), new TypeReference<List<CulturePlace>>() {});
    }

    private String request(String path) {
        try {
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            return restTemplate.getForObject(new URL("http", host, port, path).toURI(), String.class);
        } catch (Exception e) {
            // TODO : log message
            throw new RuntimeException(e);
        }
    }
}
