package com.usventuresltd.answers.controllers;

import com.usventuresltd.answers.beans.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @GetMapping("/rest") // http://localhost:8080/hello/John
    public Greeting sayHello(@RequestParam(defaultValue = "World") String name) {
        return new Greeting("Hello, " + name);
    }
}
