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
        Model model = new BindingAwareConcurrentModel(); // May have to figure out based on the actual implementaion being used in the project
        String actual = helloContorller.sayHello(name, model);

       /* // Assert
        assertEquals(expected, actual);
        //assertEquals(name, model.getAttribute("user"));
        assertEquals(name, model.asMap().get("user"));
        */
        // **** Instead of using two separate assertions, we can use assertAll() to group them together [Feature available in JUnit 5]
        // The advantage of using assertAll() is that all the assertions are executed and any failures are reported together.
        //  instead of stopping at the first failure.
        assertAll(
                () -> assertEquals(expected, actual),
                () -> assertEquals(name, model.asMap().get("user"))
        );

    }
}