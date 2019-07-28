package com.promod.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulWebServicesApplication {






	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}


	@Bean
	public LocaleResolver localeResolver(){

//	// Old Way
//		SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//		localeResolver.setDefaultLocale(Locale.US);



	// New Way
		AcceptHeaderLocaleResolver localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);

		return localeResolver;


	}

// // This is Old way the new way is putting this based name configuration in application.properties file
// // which you can see
//	@Bean
//	public ResourceBundleMessageSource bundleMessageSource(){
//
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource ;
//
//
//
//
//
//	}



}
