package com.usventuresltd.answers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloContorller {

    @GetMapping("/hello") // http://localhost:8080/hello?name=John
    public String sayHello(@RequestParam(defaultValue = "World") String name,
                           Model model) { // Model -- a collection of keys and values

        model.addAttribute("user", name);
        return "welcome";  // this would forward to src/main/resources/templates/welcome.html
    }
}
