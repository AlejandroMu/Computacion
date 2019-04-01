package com.example.demo.model;

import org.springframework.context.annotation.*;

@Configuration
public class Configurationsbean  {
	
	@Bean
	@Scope("singleton")
	public Singleton getBeanPersonSingleton() {
		return new Singleton();
	}
	
	@Bean
	@Scope("prototype")
	public Prototype getBeanPersonPrototype() {
		return new Prototype();
	}

}
