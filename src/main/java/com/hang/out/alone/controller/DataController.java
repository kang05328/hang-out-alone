package com.hang.out.alone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hang.out.alone.service.DataService;
import com.hang.out.alone.service.ESService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
public class DataController {

    private final DataService dataService;
    private final ESService esService;
    private final ObjectMapper objectMapper;

    public DataController(final DataService dataService, final ESService esService, final ObjectMapper objectMapper) {
        this.dataService = dataService;
        this.esService = esService;
        this.objectMapper = objectMapper;
    }

    @RequestMapping("/culture/place/insert")
    public String test() {
        // TODO : 메서드 명 변경 test -> addDocument
        // TODO : 테스트 데이터 실제 데이터로 변경작업
        try {
            //String testData = "{\"FAC_CODE\":\"101124\",\"SUBJCODE\":1.0,\"CODENAME\":\"공연장\",\"FAC_NAME\":\"신도림 오페라하우스\",\"ADDR\":\"서울시 구로구 구로동 3-39\"}";
            //CulturePlace culturePlace = objectMapper.readValue(Objects.requireNonNull(testData), new TypeReference<CulturePlace>() {
            //});
            //CulturePlace culturePlace = new CulturePlace("101124", "1.0", "공연장", "신도림 오페라하우스", "서울시 구로구 구로동 3-39");
            Map<String, Object> jsonMap = new HashMap<>();
            jsonMap.put("test", "test2");
            jsonMap.put("postDate", new Date());
            jsonMap.put("message", "testtest2");

            esService.addDocument(jsonMap);
            return "index";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
