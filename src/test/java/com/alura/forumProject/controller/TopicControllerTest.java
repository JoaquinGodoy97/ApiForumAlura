package com.alura.forumProject.controller;

import com.alura.forumProject.service.TopicService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


//@SpringBootTest
//@AutoConfigureMockMvc
class TopicControllerTest {
//    @Autowired
    private MockMvc mockMvc;

//    @MockitoBean
    private TopicService topicService;

//    @Test
    void shouldReturn500WhenServiceThrowsException() throws Exception {

        when(topicService.findById(anyLong()))
                .thenThrow(new RuntimeException("Database crashed"));

        MvcResult result = mockMvc.perform(get("/v1/topic/1"))
                .andExpect(status().isInternalServerError())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }
}
