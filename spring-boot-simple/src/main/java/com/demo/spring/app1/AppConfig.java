package com.demo.spring.app1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
public class AppConfig {

    @Bean
    public List<String> petList(){
        List<String> petList= Arrays.asList("Lion","Tiger","Cat","Dog");
        return petList;
    }
}
