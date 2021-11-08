package com.demo.spring.rest;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface IDemo {
    @RequestMapping(path="/find/{name}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity findUser(@PathVariable("name") String userName);
}
