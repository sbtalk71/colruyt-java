package com.demo.spring;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyBatchMain {
    public static void main(String[] args) throws Exception{
        ApplicationContext ctx = new AnnotationConfigApplicationContext(BatchConfig.class);

        JobLauncher jobLauncher=ctx.getBean(JobLauncher.class);
        Job job=(Job) ctx.getBean("job1");
        JobParameters params=new JobParametersBuilder()
                .addString("jobId",System.currentTimeMillis()+"")
                .toJobParameters();
        JobExecution jobExecution=jobLauncher.run(job,params);

        System.out.println(jobExecution.getJobId());
        System.out.println(jobExecution.getCreateTime());
        System.out.println(jobExecution.getEndTime());
    }
}
