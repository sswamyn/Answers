package com.usventuresltd.answers.controllers;

import com.usventuresltd.answers.beans.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) // starts the server with a random port
public class HelloRestControllerFunctionalTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void sayHelloWithoutName() {
        assertNotNull(restTemplate);
        Greeting response = restTemplate.getForObject("/rest", Greeting.class);
        assertEquals("Hello, World", response.message());

    }

    @Test
    public void sayHelloWithName() {
        assertNotNull(restTemplate);

        ResponseEntity<Greeting> response = restTemplate.getForEntity("/rest?name=Sarika", Greeting.class);

        assertAll(
                () -> assertNotNull(response),
                () -> assertTrue(response.getStatusCode().is2xxSuccessful()),
                () -> assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType()),
                () -> assertEquals("Hello, Sarika", Objects.requireNonNull(response.getBody()).message())
                //Objects.requireNonNull() was used since the response.getBody() could be null
        );

    }
}
