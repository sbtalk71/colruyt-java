package com.demo.spring.clients;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class POSTClient {
    public static void main(String[] args) {
        RestTemplate rt= new RestTemplate();

        HttpHeaders headers= new HttpHeaders();
        headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
        headers.set("Content-Type",MediaType.APPLICATION_JSON_VALUE);

        Emp emp=new Emp(403,"Raman","Chennai",67000);
        HttpEntity req = new HttpEntity(emp,headers);

        ResponseEntity<String> respEntity=rt.exchange("http://localhost:8081/emp/save", HttpMethod.POST,req,String.class);

        System.out.println(respEntity.getBody());
    }
}
