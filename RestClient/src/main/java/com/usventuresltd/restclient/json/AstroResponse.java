package com.usventuresltd.restclient.json;

import java.util.List;

public record AstroResponse(String message,  List<Astronaut> people, int number) {
}