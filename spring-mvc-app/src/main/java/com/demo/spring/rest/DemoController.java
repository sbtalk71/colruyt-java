package com.demo.spring.rest;

import com.demo.spring.controllers.model.User;
import com.demo.spring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class DemoController {
    @Autowired
    UserRepository repo;

    @RequestMapping(path="/find/{name}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity findUser(@PathVariable("name") String userName){
       Optional<User> empOpt=repo.findById(userName);
       if(empOpt.isPresent()){
           return ResponseEntity.ok(empOpt.get());
       }else{
           return ResponseEntity.ok("{\"status\":\"Not Found\"}");
       }
    }
}
