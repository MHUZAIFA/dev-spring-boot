package com.huzaifa.practice.mypracticeapp.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestController {
    // expose "/" that returns "Hello World"
    @GetMapping("/")
    public String SayHelloWorld() {
        return "<h1>Hello World!!!</h1>";
    }
}
