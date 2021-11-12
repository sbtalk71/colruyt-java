package com.demo.spring;

import com.demo.spring.model.Emp;
import com.demo.spring.step.EmpFieldSetMapper;
import com.demo.spring.step.EmpItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;


@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableBatchProcessing
public class BatchConfig {
    @Value("input/employees.csv")
    Resource inputResource;
    @Value("file:xml/emp.xml")
    Resource outFile;

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
    public FlatFileItemReader<Emp> fileItemReader() {
        FlatFileItemReader<Emp> fileReader = new FlatFileItemReader<>();
        fileReader.setResource(inputResource);

        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(",");
        tokenizer.setNames("empId", "name", "city", "salary");

        DefaultLineMapper<Emp> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new EmpFieldSetMapper());

        fileReader.setLineMapper(lineMapper);
        return fileReader;
    }

    @Bean
    public ItemWriter<Emp> itemWriter() {
        StaxEventItemWriter writer = new StaxEventItemWriter();
        writer.setRootTagName("emp-data");
        writer.setMarshaller(marshaller());
        writer.setResource(outFile);
        return writer;
    }


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setClassesToBeBound(Emp.class);
        return marshaller;
    }

    @Bean
    public EmpItemProcessor processor(){
        return new EmpItemProcessor();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step-1")
                .<Emp, Emp>chunk(2)
                .reader(fileItemReader())
                .processor(processor())
                .writer(itemWriter()).build();
    }

    @Bean
    public Job job1() {
        return jobBuilderFactory.get("job-1").start(step1()).build();

    }

}
