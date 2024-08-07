package com.huzaifa.practice.mypracticeapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {

    @Value("${message.hello_world_title}")
    private String title;

    @Value("${message.hello_world_description}")
    private String description;

    @Value("${message.hello_world_disclaimer}")
    private String disclaimer;

    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String SayHelloWorld() {
        return "<div style=\"text-align: center\">"
                + "<h1>" + title + "</h1>"
                + "<p>" + description + "</p>"
                + disclaimer +
                "</div>";
    }
}
