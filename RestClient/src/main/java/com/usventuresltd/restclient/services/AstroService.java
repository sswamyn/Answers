package com.usventuresltd.restclient.services;


import com.usventuresltd.restclient.json.AstroResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

@Service
public class AstroService {
    private final RestTemplate restTemplate;
    private final WebClient webClient;

    public AstroService(RestTemplateBuilder builder) {
        this.restTemplate = builder.rootUri("http://api.open-notify.org").build();
        this.webClient = WebClient.create("http://api.open-notify.org");
    }

    public String getPeopleInSpace() {
        return this.restTemplate.getForObject("/astros.json", String.class);
    }

    public AstroResponse getAstroResponse() {
        return this.restTemplate.getForObject("/astros.json", AstroResponse.class);
    }

    public AstroResponse getAstroResponseAsync() {
        return this.webClient.get()
                .uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResponse.class)
                .block(Duration.ofMillis(500)); // block for 500 milliseconds
    }
}
