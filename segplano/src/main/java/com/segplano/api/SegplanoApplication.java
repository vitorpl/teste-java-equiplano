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
	    	
	    	LocalDate startLocalDate = LocalDate.of(2022, 1, 1);
			LocalDate endLocalDate = LocalDate.of(2020, 7, 20);
			 
			Period periodBetween = Period.between(startLocalDate, endLocalDate);
			//Duration durationBetween = Duration.between(startLocalDate, endLocalDate);
			//System.out.println(durationBetween.get(ChronoUnit.DAYS));
			//System.out.println(ChronoUnit.DAYS.between(startLocalDate, endLocalDate));
			System.out.println(ChronoUnit.DAYS.between(startLocalDate, endLocalDate));
			
			System.out.println(periodBetween.getYears());
			System.out.println(periodBetween.getMonths());
			System.out.println(periodBetween.getDays());
	    	
	    	Calendar cal = Calendar.getInstance();
			//cal.getTimeInMillis();
			Random rnd = new Random(cal.getTimeInMillis());
			System.out.println( "Rdn>"+rnd.nextLong()); 
			/*
			Estado estado = new Estado();
			estado.setSigla("PR");
			estado.setNome("Paraná");
			estadoDao.saveAndFlush(estado);
			
			Cidade cidade = new Cidade();
			cidade.setEstado(estado);
			cidade.setNome("Curitiba");
			cidadeDao.saveAndFlush(cidade);
			
			Estado estado2 = new Estado();
			estado2.setSigla("SC");
			estado2.setNome("Santa Catarina");
			estadoDao.saveAndFlush(estado2);
			
			Cidade cidade2 = new Cidade();
			cidade2.setEstado(estado2);
			cidade2.setNome("Joinville");
			cidadeDao.saveAndFlush(cidade2);
			*/
	    }
	}
	

	
	
	
    
    

}
