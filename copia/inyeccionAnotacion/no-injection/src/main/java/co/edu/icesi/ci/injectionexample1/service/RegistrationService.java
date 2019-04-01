package co.edu.icesi.ci.injectionexample1.service;

import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

	public boolean enrolStudent(String studentId, String courseId, int semester);
}
