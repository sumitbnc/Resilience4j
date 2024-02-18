package com.example.demo.controller;

import com.example.demo.configurations.ControllerTestConfiguration;
import com.example.demo.services.StoreService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
@ExtendWith(OutputCaptureExtension.class)
@WebMvcTest(StoreController.class)
@Import(ControllerTestConfiguration.class)
public class StoreControllerTest {

    @Autowired
    StoreService storeService;

    @Autowired
    protected MockMvc mockMvc;


    @Test
    public void testGetAllStores() throws Exception {
        mockMvc.perform(get("/store/getAllStores").header("Bearer", "dummytoken").contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("testString"));
                //.andExpect(jsonPath("$.storeId").value("STORE_ID"))
                //.andExpect(jsonPath("$.queueId").value("store.getQueueId()"));
    }
}
