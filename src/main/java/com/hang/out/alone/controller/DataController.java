package com.hang.out.alone.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hang.out.alone.service.DataService;
import com.hang.out.alone.service.ESService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DataController {

    private final DataService dataService;
    private final ESService esService;
    private final ObjectMapper objectMapper;
    private final String CULTURE_PLACE = "culture_place";
    private final String CULTURE_EVENT = "culture_event";

    public DataController(final DataService dataService, final ESService esService, final ObjectMapper objectMapper) {
        this.dataService = dataService;
        this.esService = esService;
        this.objectMapper = objectMapper;
    }

    // TODO : POST 로 변경
    @RequestMapping("/culture/place/insert")
    public String insertPlace() {
        try {
            String jsonString = dataService.culturePlace();
            esService.addDocument(jsonString, CULTURE_PLACE);
            return "index";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // TODO : POST 로 변경
    @RequestMapping("/culture/event/insert")
    public String insertEvent() {
        try {
            String jsonString = dataService.cultureEvent();
            esService.addDocument(jsonString, CULTURE_PLACE);
            return "index";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
