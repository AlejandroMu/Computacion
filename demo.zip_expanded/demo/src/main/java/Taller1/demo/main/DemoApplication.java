package Taller1.demo.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("Taller1.demo")
public class DemoApplication {
	
	
	

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx= SpringApplication.run(DemoApplication.class, args);
	
		 ctx.getBean("demoApplication");
	
	}

}

