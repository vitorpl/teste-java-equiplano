package com.segplano.api;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

@SpringBootApplication
public class SegplanoApplication extends SpringBootServletInitializer { //extends SpringBootServletInitializer para war

	public static void main(String[] args) {
		SpringApplication.run(SegplanoApplication.class, args);
	}
	
	@Bean
	public FixedLocaleResolver localeResolver() {
		return new FixedLocaleResolver(new Locale("pt", "BR"));
	}
	
	@Component
	public class ServerInitializer implements ApplicationRunner {
		
	    @Override
	    public void run(ApplicationArguments applicationArguments) throws Exception {
	    	
	    	
	    }
	}
	

	
	
	
    
    

}
