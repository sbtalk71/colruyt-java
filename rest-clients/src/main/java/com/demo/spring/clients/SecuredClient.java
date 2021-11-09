package com.demo.spring.clients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

public class SecuredClient {
    public static void main(String[] args) {
        String credentials="shantanu:welcome1";
        byte[] credBytes=credentials.getBytes();
        String encodedCredentials=new String(Base64.getEncoder().encode(credBytes));

        Logger LOGGER=LoggerFactory.getLogger(SecuredClient.class);
        LOGGER.info("rest Template created");
        RestTemplate rt= new RestTemplate();

        //rt.exchange
        HttpHeaders headers= new HttpHeaders();
        headers.set("Accept", MediaType.TEXT_PLAIN_VALUE);
        headers.set("Authorization","Basic "+encodedCredentials);

        LOGGER.info("Headers created");
        HttpEntity req = new HttpEntity(headers);

        LOGGER.info("Client Made the request");
        ResponseEntity<String> respEntity=rt.exchange("http://localhost:8080/services/greet", HttpMethod.GET,req,String.class);

        System.out.println(respEntity.getBody());
    }
}
