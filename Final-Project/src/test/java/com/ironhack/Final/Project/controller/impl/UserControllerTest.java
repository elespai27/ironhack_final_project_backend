package com.ironhack.Final.Project.controller.impl;

import com.ironhack.Final.Project.model.User;
import com.ironhack.Final.Project.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {



    @Autowired
    private UserRepository userRepository;


    @Autowired
    private MockMvc mockMvc;


    @BeforeEach
    void setUp() {
        userRepository.save(new User("tester1", "test1@email.com", "pass1"));
        userRepository.save(new User("tester2", "test2@email.com", "pass2"));
    }
    @AfterEach
    void tearDown() {
        userRepository.deleteAll();
    }


    @Test
    void getAllUser_validRequest_allUsers() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        String responseContent = mvcResult.getResponse().getContentAsString();
        assertTrue(responseContent.contains("tester1"));
        assertTrue(responseContent.contains("tester2"));


    }
}