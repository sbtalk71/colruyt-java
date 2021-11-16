package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class DemoController {

    @Autowired
    MessageService ms;
    @Autowired
    PersonRepository personRepository;

    @GetMapping(path = "demo")
    @ResponseBody
    public String getMessage() {
        return "hello";
    }

    @GetMapping(path = "find/{name}",produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Person findPerson(@PathVariable("name") String name){
       return personRepository.findPersonByfirstName(name);
       // return "";
    }

    @GetMapping(path="demo/service")
    @ResponseBody
    public String getService(){
        return ms.getMessage();
    }

    @GetMapping(path="person/list",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Person> listAll(){
        return personRepository.listAllPersons();
    }

}
