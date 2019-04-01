package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.RepositoryUno;

@SpringBootApplication
public class TallerpreParcial2Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(TallerpreParcial2Application.class, args);
		RepositoryUno re=ctx.getBean(RepositoryUno.class);
		re.init();
		
	}

}
