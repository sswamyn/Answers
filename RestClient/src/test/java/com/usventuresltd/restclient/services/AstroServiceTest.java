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
        System.out.println("Response: {}" + response);
        assertNotNull(response);
        assertTrue(response.contains("people"));
        System.out.println("\n\tResponse: \n" + response + "\n\n");

        // Parse the response object as a JSON object and print a formatted json string
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            JsonNode jsonNode = mapper.readTree(response);
            String prettyJson = mapper.writeValueAsString(jsonNode);
            System.out.println("Formatted JSON:\n" + prettyJson);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    void getAstroResponse() {
        AstroResponse response = astroService.getAstroResponse();
        assertNotNull(response);
        assertEquals("success", response.message());
        //assertTrue(response.number() >= 0);
        System.out.println("#######\n\n" + response + "#######\n\n");
       // assertEquals(response.peopleList().size(), response.number());
        //response.astronauts().forEach(System.out::println);
        response.people().forEach(System.out::println);
        System.out.println("#######\n\n" + response + "#######\n\n");

    }
}