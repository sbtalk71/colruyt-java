package com.demo.spring;

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
public class JobRUnnerDemo implements CommandLineRunner {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("importUserJob")
    Job job;

    @Override
    public void run(String... args) throws Exception {
        JobParameters params=new JobParametersBuilder()
                .addString("jobId",System.currentTimeMillis()+"")
                .toJobParameters();
        JobExecution jobExecution=jobLauncher.run(job,params);

        System.out.println(jobExecution.getJobId());
        System.out.println(jobExecution.getCreateTime());
        System.out.println(jobExecution.getEndTime());
        System.out.println(jobExecution.getStatus());
    }
}
