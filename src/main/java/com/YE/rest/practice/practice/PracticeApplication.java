package com.YE.rest.practice.practice;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@SpringBootApplication
@ComponentScan(basePackages= {"com.YE.rest.practice.practice","com.YE.rest.practice.practice.HW",
		"com.YE.rest.practice.practice.user","Exception","filtering"})
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}
	@Bean
	public AcceptHeaderLocaleResolver localeResolver()
	{
		AcceptHeaderLocaleResolver localeresolver=new AcceptHeaderLocaleResolver();
		localeresolver.setDefaultLocale(Locale.US);
		return localeresolver;
	}
//	@Bean
//	public ResourceBundleMessageSource bundleMessageSource()
//	{
//		ResourceBundleMessageSource msgsrc=new ResourceBundleMessageSource();
//		msgsrc.setBasename("messages");
//		return msgsrc;
//	}
}
