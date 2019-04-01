package co.edu.icesi.ci.junit.spring.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.icesi.ci.junit.spring.repository.*;
import co.edu.icesi.ci.junit.spring.service.SampleService;
import co.edu.icesi.ci.junit.spring.service.SampleServiceImpl;

@Configuration
public class AppConfig {
	@Bean
	public SampleService getSampleService() {
		return new SampleServiceImpl();
	}
	@Bean
	public SampleRepository getSampleRepository() {
		return new SampleRepositoryImpl();
	}
}
