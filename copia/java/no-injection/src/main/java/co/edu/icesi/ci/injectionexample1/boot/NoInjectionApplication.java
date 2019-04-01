package co.edu.icesi.ci.injectionexample1.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import co.edu.icesi.ci.injectionexample1.service.RegistrationService;
import co.edu.icesi.ci.injectionexample1.service.RegistrationServiceImp;

@SpringBootApplication
public class NoInjectionApplication {
	@Autowired
	private  RegistrationService registration;
	public void enrrol() {
		registration.enrolStudent("11","101",192);

	}
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx= SpringApplication.run(NoInjectionApplication.class, args);
		NoInjectionApplication tmp=(NoInjectionApplication) ctx.getBean("noInjectionApplication");
		tmp.enrrol();
		
	}

}

