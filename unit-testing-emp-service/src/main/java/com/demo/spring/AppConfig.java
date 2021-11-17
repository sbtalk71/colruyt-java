package com.demo.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

    @Bean
    //@Primary
    @Profile("prod")
    public DriverManagerDataSource dataSource(){
        System.out.println("Production Datasoure is being used..");
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@//localhost:1521/XE");
        ds.setUsername("system");
        ds.setPassword("welcome1");
        return ds;
    }

    @Bean
    @Profile("testing")
    public DriverManagerDataSource dataSource1(){
        System.out.println("Testing Datasoure is being used..");
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@//localhost:1521/XE");
        ds.setUsername("system");
        ds.setPassword("welcome1");
        return ds;
    }
}
