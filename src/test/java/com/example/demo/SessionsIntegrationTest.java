package com.example.demo;


import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.controllers.SessionsController;
import com.example.demo.models.Session;
import com.example.demo.repositories.SessionRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(SessionsController.class)
public class SessionsIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SessionRepository service;

    @Test
    public void greetingShouldReturnMessageFromService() throws Exception {

        List<Session> sessions = new ArrayList<>();
        when(service.findAll()).thenReturn(sessions);
        this.mockMvc.perform(get("/api/v1/sessions")).andDo(print()).andExpect(status().isOk());

    }
}