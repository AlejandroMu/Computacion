package co.edu.icesi.ci.injectionexample1.boot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.edu.icesi.ci.injectionexample1.repositories.*;
import co.edu.icesi.ci.injectionexample1.service.*;

@Configuration
public class Beans {
	
	@Bean(name="repository")
	public CourseRepository getBeanCourseRepository() {
		return new CourseRepositoryImp();
	}
	@Bean(name="repository2")
	public RegistrationRepository getBeanRegistrationRepository() {
		return new RegistrationRepositoryImp();
	}
	@Bean(name="repository3")
	public StudentRepository getBeanStudentRepository() {
		return new StudentRepositoryImp();
	}
	@Bean(name="service")
	public RegistrationService getBeanRegistrationService() {
		return new RegistrationServiceImp(getBeanStudentRepository(),getBeanCourseRepository(),getBeanRegistrationRepository());
	}
}
