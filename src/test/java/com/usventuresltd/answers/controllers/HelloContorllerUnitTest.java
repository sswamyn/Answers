package com.usventuresltd.answers.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareConcurrentModel;

import static org.junit.jupiter.api.Assertions.*;

class HelloContorllerUnitTest {

    @Test
    void sayHello() {
        // Arrange
        HelloContorller helloContorller = new HelloContorller();
        String name = "John";
        String expected = "welcome";

        // Act
        Model model = new BindingAwareConcurrentModel();
        String actual = helloContorller.sayHello(name, model);

        // Assert
        assertEquals(expected, actual);
        //assertEquals(name, model.getAttribute("user"));
        assertEquals(name, model.asMap().get("user"));
    }
}