package com.YE.rest.practice.practice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}
	@Bean
	public SessionLocaleResolver localeResolver()
	{
		SessionLocaleResolver localeresolver=new SessionLocaleResolver();
		localeresolver.setDefaultLocale(Locale.US);
		return localeresolver;
	}
	@Bean
	public ResourceBundleMessageSource bundleMessageSource()
	{
		ResourceBundleMessageSource msgsrc=new ResourceBundleMessageSource();
		msgsrc.setBasename("messages");
		return msgsrc;
	}
}
