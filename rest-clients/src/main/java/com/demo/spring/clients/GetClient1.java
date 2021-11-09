package com.demo.spring.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class GetClient1 {
    public static void main(String[] args) {
        Logger LOGGER=LoggerFactory.getLogger(GetClient1.class);
        LOGGER.info("rest Template created");
        RestTemplate rt= new RestTemplate();
      //  String resp=rt.getForObject("http://localhost:8081/emp/find/104",String.class);
      //  System.out.println(resp);

        //rt.exchange
        HttpHeaders headers= new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        LOGGER.info("Headers created");
        HttpEntity req = new HttpEntity(headers);

        LOGGER.info("Client Made the request");
        ResponseEntity<String> respEntity=rt.exchange("http://localhost:8081/emp/find/104", HttpMethod.GET,req,String.class);

        System.out.println(respEntity.getBody());
    }
}
