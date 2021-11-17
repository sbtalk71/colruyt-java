package com.demo.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.MessageSourceResourceBundle;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringMvcAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcAppApplication.class, args);
	}

	@Bean
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource ms=new ResourceBundleMessageSource();
		ms.setBasenames("messages");
		ms.setFallbackToSystemLocale(false);
		ms.setDefaultLocale(Locale.FRENCH);
		return ms;
	}

	@Bean
	public SessionLocaleResolver localResolver(){
		SessionLocaleResolver sl= new SessionLocaleResolver();
		sl.setDefaultLocale(Locale.FRENCH);
		return sl;
	}
}
