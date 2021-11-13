package com.demo.spring;

import com.demo.spring.model.Person;
import com.demo.spring.step.PersonFieldSetMapper;
import com.demo.spring.step.PersonItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import javax.sql.DataSource;


@Configuration
@ComponentScan(basePackages = "com.demo.spring")
@EnableBatchProcessing
public class BatchConfig {
    @Value("input/person*.csv")
    Resource[] inputResource;

    @Autowired
    DataSource ds;

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Bean
    public MultiResourceItemReader<Person> multiCSVReader(){
        MultiResourceItemReader<Person> multiReader=new MultiResourceItemReader<>();
        multiReader.setResources(inputResource);
        multiReader.setDelegate(fileItemReader());
        return multiReader;
    }
    @Bean
    public FlatFileItemReader<Person> fileItemReader() {
        FlatFileItemReader<Person> fileReader = new FlatFileItemReader<>();

       DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer(",");
        tokenizer.setNames("id", "firstName", "lastName");

        DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(new PersonFieldSetMapper());

        fileReader.setLineMapper(lineMapper);
        return fileReader;
    }

    @Bean
    public JdbcBatchItemWriter<Person> itemWriter(){
        JdbcBatchItemWriter<Person> writer=new JdbcBatchItemWriter<>();
        writer.setDataSource(ds);
        writer.setSql("insert into Person(id,firstname,lastname) values(:id,:firstName,:lastName)");
        writer.setItemSqlParameterSourceProvider( new BeanPropertyItemSqlParameterSourceProvider<Person>());
        return writer;

    }

    @Bean
    public PersonItemProcessor processor(){
        return new PersonItemProcessor();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step-1")
                .<Person, Person>chunk(2)
                .reader(multiCSVReader())
                .processor(processor())
                .writer(itemWriter()).build();
    }

    @Bean
    public Job job1() {
        return jobBuilderFactory.get("job-1").start(step1()).build();

    }

}
