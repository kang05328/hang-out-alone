package com.hang.out.alone.controller;

import com.hang.out.alone.service.DataService;
import com.hang.out.alone.service.ESService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = DataController.class)
@AutoConfigureMybatis
class DataControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DataService dataService;

    @MockBean
    private ESService esService;

    @Test
    void insertPlace() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/culture/place/insert"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void insertEvent() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/culture/event/insert"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}