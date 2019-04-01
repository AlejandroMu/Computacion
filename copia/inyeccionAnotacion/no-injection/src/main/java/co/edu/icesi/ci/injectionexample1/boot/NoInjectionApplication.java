package co.edu.icesi.ci.injectionexample1.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import co.edu.icesi.ci.injectionexample1.service.RegistrationService;
import co.edu.icesi.ci.injectionexample1.service.RegistrationServiceImp;

@SpringBootApplication
@ComponentScan("co.edu.icesi.ci.injectionexample1")

public class NoInjectionApplication {
	
	private static RegistrationService registration;

	public static void main(String[] args) {
		
		ConfigurableApplicationContext tmp= SpringApplication.run(NoInjectionApplication.class, args);
		registration=(RegistrationService) tmp.getBean("registrationServiceImp");
		
		registration.enrolStudent("11","101",192);
		
	}

}

