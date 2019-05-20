package com.taller.tallerjpa;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration("/applicationContext.xml")
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext con = SpringApplication.run(DemoApplication.class);
		String[] b = con.getBeanDefinitionNames();
		EntityManager en= con.getBean(EntityManager.class);
		
		System.out.println("Beans --------------");
		System.out.println("manager "+en);
		for (String var : b) {
			System.out.println(var);
		}
	}

}
