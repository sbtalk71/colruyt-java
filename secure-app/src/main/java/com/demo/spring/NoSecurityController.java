package com.demo.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("all")
public class NoSecurityController {
    @RequestMapping(path="freepage",method = RequestMethod.GET)
    public String getPage(){
        return "freedom";
    }
}
