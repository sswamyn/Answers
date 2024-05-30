package com.usventuresltd.restclient.services;

import com.usventuresltd.restclient.json.AstroResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface AstroInterface {
    @GetExchange("/astros.json")
    AstroResponse getAstroResponse();
}
