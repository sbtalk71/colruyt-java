package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HRController {
    @Autowired
    RestTemplate rt;

    @GetMapping(path="/hr/get")
    public ResponseEntity<String> getEmpDetails(@RequestParam("id") int id){
        return rt.getForEntity("http://emp-service/emp/find/"+id,String.class);
    }
}
