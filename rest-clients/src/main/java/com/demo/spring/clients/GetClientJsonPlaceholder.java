package com.demo.spring.clients;

import org.springframework.web.client.RestTemplate;

public class GetClientJsonPlaceholder {
    public static void main(String[] args) {
        RestTemplate rt= new RestTemplate();
        String resp=rt.getForObject("https://jsonplaceholder.typicode.com/posts/2",String.class);
        System.out.println(resp);



    }
}
