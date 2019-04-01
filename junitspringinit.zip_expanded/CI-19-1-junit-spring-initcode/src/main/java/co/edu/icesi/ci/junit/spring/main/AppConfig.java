package co.edu.icesi.ci.junit.spring.main;
//https://examples.javacodegeeks.com/core-java/junit/spring-junit-test-example/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.icesi.ci.junit.spring.service.SampleService;
import co.edu.icesi.ci.junit.spring.service.SampleServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public SampleService getSampleService() {
		return new SampleServiceImpl();
	}
}
