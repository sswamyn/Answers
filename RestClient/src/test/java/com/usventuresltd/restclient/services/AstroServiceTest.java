package com.usventuresltd.restclient.services;

import com.usventuresltd.restclient.json.AstroResponse;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroServiceTest {
    private static final Logger log = LoggerFactory.getLogger(AstroServiceTest.class);
    @Autowired
    private AstroService astroService;

    @Test
    void getPeopleInSpace() {
        assertNotNull(astroService);
        String response = astroService.getPeopleInSpace();
        assertNotNull(response);
        assertTrue(response.contains("people"));
    }

    @Test
    void getAstroResponse() {
        AstroResponse response = astroService.getAstroResponse();
        assertNotNull(response);
        assertEquals("success", response.message());
        assertTrue(response.number() >= 0);
        assertEquals(response.people().size(), response.number());
        response.people().forEach(System.out::println);
        System.out.println(response);
    }

    @Test
    void getAstroResponseAsync() {
        AstroResponse response = astroService.getAstroResponseAsync();
        assertNotNull(response);
        assertEquals("success", response.message());
        assertTrue(response.number() >= 0);
        assertEquals(response.people().size(), response.number());
        response.people().forEach(System.out::println);
        System.out.println(response);
    }
}