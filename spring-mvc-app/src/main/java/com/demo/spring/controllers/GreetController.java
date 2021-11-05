package com.demo.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetController {
    @RequestMapping(path="test",method = RequestMethod.GET)
    public String greet(){
        return "greet";
    }

    /* http://localhost:8080/greet?name=Scott */
    @RequestMapping(path="greet",method = RequestMethod.GET)
    public ModelAndView greetWithName(@RequestParam("name") String name){
        ModelAndView mv= new ModelAndView();
        mv.addObject("user",name);
        mv.setViewName("greetName");
        return mv;
    }
}
