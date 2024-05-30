package com.usventuresltd.restclient.services;

import com.usventuresltd.restclient.json.AstroResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AstroInterfaceTest {
    @Autowired
    private AstroInterface astroInterface;

    @Test
    void getAstroResponse() {
        AstroResponse response = astroInterface.getAstroResponse();
        assertNotNull(response);
        assertEquals("success", response.message());
        assertTrue(response.number() >= 0);
        assertEquals(response.people().size(), response.number());
        response.people().forEach(System.out::println);
        System.out.println(response);
    }
}