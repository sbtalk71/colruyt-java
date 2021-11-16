package com.demo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    @GetMapping(path = "demo")
    @ResponseBody
    public String getMessage() {
        return "hello";
    }
}
