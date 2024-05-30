package com.usventuresltd.restclient.services;


import com.usventuresltd.restclient.json.AstroResponse;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AstroService {
    private final RestTemplate restTemplate;

    public AstroService(RestTemplateBuilder builder) {
        this.restTemplate = builder.rootUri("http://api.open-notify.org").build();
    }

    public String getPeopleInSpace() {
        String response = this.restTemplate.getForObject("/astros.json", String.class);
        return response;
        //return this.restTemplate.getForObject("/astros.json", String.class);
    }

    public AstroResponse getAstroResponse() {
        return this.restTemplate.getForObject("/astros.json", AstroResponse.class);
    }

}
