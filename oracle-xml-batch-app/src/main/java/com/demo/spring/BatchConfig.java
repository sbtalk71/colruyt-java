package com.demo.spring;

import com.demo.spring.model.Emp;
import com.demo.spring.step.EmpItemProcessor;
import com.demo.spring.step.EmpRowMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableBatchProcessing
public class BatchConfig {
    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    DataSource ds;

    @Value("file:xml/employees.xml")
    Resource outputLocation;

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marshaller=new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Emp.class);
        return  marshaller;
    }

    @Bean
    public StaxEventItemWriter<Emp> itemWriter(){
        StaxEventItemWriter<Emp> writer=new StaxEventItemWriter<>();
        writer.setRootTagName("emp-list");
        writer.setResource(outputLocation);
        writer.setMarshaller(marshaller());
        return writer;
    }

    @Bean
    public ItemProcessor<Emp,Emp> empItemProcessor(){
        return new EmpItemProcessor();
    }

    @Bean
    public JdbcCursorItemReader<Emp> itemReader(){
        JdbcCursorItemReader<Emp> reader=new JdbcCursorItemReader<>();
        reader.setDataSource(ds);
        reader.setSql("select * from emp");
        reader.setRowMapper(new EmpRowMapper());
        return reader;
    }

    @Bean
    public Step step1(){
        return stepBuilderFactory.get("step-1").<Emp,Emp>chunk(4)
                .reader(itemReader())
                .processor(empItemProcessor())
                .writer(itemWriter())
                .faultTolerant()
                .retry(Exception.class)
                .retryLimit(5)
                .build();
    }

    @Bean
    public Job job1(){
        return jobBuilderFactory.get("job-1").start(step1()).build();
    }
}
