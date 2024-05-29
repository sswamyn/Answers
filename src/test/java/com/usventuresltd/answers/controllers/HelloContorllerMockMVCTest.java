package com.usventuresltd.answers.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HelloContorller.class)  // This annotation is used to test the HelloContorller class
public class HelloContorllerMockMVCTest {
    @Autowired
    private MockMvc mockMvc;

    // Write your test cases here
    // First let us check to make sure Spring injected the MockMvc instance
    @Test
    void testMockMvc() {
        assertNotNull(mockMvc);
    }

    @Test
    void testHellpWithoutName() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(view().name("welcome"))
                .andExpect(model().attribute("user", "World"));
    }

}
