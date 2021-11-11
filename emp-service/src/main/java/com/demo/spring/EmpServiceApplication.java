package com.demo.spring;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class EmpServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmpServiceApplication.class, args);
	}


@Bean
	public OpenAPI openApiDoc(){
		return new OpenAPI().info(new Info()
				.title("Employee Data Services")
				.license(new License().name("Free License"))
				.version("1.0.1")
				.description("This is a demo application for Emp data")
				.termsOfService("http://nowhere_to_go.org")
		);
}
}
