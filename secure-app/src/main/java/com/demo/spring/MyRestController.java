package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services")
public class MyRestController {

    @GetMapping(path = "greet")
    public String greet() {
        return "Welcome to Secured Rest Service";
    }
}
