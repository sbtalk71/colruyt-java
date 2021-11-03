package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication

public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
