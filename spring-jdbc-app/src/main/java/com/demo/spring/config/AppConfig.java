package com.demo.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
   /* @Bean
    public DriverManagerDataSource dataSource(){
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@//localhost:1521/XE");
        ds.setUsername("system");
        ds.setPassword("welcome1");
        return ds;
    }*/

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource ds){
        JdbcTemplate jt = new JdbcTemplate(ds);
        return jt;
    }
}
