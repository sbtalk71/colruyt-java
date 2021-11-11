package com.demo.spring;

import com.demo.spring.step.MessagePrinter;
import com.demo.spring.step.MyStringModifier;
import com.demo.spring.step.StringGenerator;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableBatchProcessing
public class BatchConfig {
   /* @Bean
    public DriverManagerDataSource dataSource(){
        System.out.println("Production Datasoure is being used..");
        DriverManagerDataSource ds= new DriverManagerDataSource();
        ds.setDriverClassName("oracle.jdbc.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@//localhost:1521/XE");
        ds.setUsername("system");
        ds.setPassword("welcome1");
        return ds;
    }*/
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step-1")
                .<String,String>chunk(5)
                .reader(new StringGenerator())
                .processor(new MyStringModifier())
                .writer(new MessagePrinter()).build();
    }

    @Bean
    public Job job1(){
        return jobBuilderFactory.get("job-1").start(step1()).build();

    }

}
