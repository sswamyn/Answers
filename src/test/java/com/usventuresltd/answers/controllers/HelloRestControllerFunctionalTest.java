package com.usventuresltd.answers.controllers;

import com.usventuresltd.answers.beans.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // starts the server with a random port
public class HelloRestControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sayHello() {
        assertNotNull(restTemplate);
        Greeting result = restTemplate.getForObject("/rest", Greeting.class);
        assertEquals("Hello, World", result.message());

        // Reusing the variable 'result' to store the response from the server; Kind of risky!
        result = restTemplate.getForObject("/rest?name=Sarika", Greeting.class);
        assertThat(result.message()).isEqualTo("Hello, Sarika");

    }
}
