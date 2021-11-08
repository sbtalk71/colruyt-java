package com.demo.spring.ws;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@RestController
@RequestMapping("/maths")
public class Maths {

    @RequestMapping(path="add",method = RequestMethod.GET)
    public int add(@RequestParam("a") int a, @RequestParam("b")int b){
        return a+b;
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8181/maths",new Maths());
    }
}
