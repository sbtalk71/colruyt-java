package com.demo.spring.runners;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner1 implements CommandLineRunner {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("job1")
    Job job;

    @Override
    public void run(String... args) throws Exception {

        JobParameters params=new JobParametersBuilder().addString("job-id",""+System.currentTimeMillis()).toJobParameters();
        JobExecution jobExecution=jobLauncher.run(job,params);
        System.out.println(jobExecution.getStatus());
    }
}
