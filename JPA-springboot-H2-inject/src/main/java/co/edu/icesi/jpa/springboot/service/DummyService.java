package co.edu.icesi.jpa.springboot.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.jpa.springboot.crud.AlumnosRepository;
import co.edu.icesi.jpa.springboot.crud.MateriasRepository;
import co.edu.icesi.jpa.springboot.dao.ITAlumnoDao;
import co.edu.icesi.jpa.springboot.model.TAlumno;

import lombok.extern.java.Log;

@Service
@Log
public class DummyService {

	@Autowired
	AlumnosRepository alumnosRepository;
	
	@Autowired
	MateriasRepository materiasRepository;
	
	@Autowired
	ITAlumnoDao dao;
	
	@Transactional()
	@PostConstruct
	void demo2() {
		alumnosRepository.save(new TAlumno("Jack", "Bauer", "M", "E"));
		alumnosRepository.save(new TAlumno("Chloe", "O'Brian", "M", "E"));
		alumnosRepository.save(new TAlumno("Kim", "Bauer", "M", "E"));
		alumnosRepository.save(new TAlumno("David", "Palmer", "M", "E"));
		alumnosRepository.save(new TAlumno("Michelle", "Dessler", "M", "E"));

		//dao.save(new TAlumno("Jack", "Bauer", "M", "E"));

		// fetch all alumnos
		log.info("Customers found with findAll():");
		log.info("-------------------------------");
		for (TAlumno alumno : alumnosRepository.findAll()) {
			log.info(alumno.toString());
		}
		log.info("" + alumnosRepository.findAll());

		// fetch all customers
		log.info("alumnos found with findAll():");
		log.info("-------------------------------");
		for (TAlumno alumno : alumnosRepository.findAll()) {
			log.info(alumno.toString());
		}
		log.info("");

		// fetch an individual alumno by codigo
		alumnosRepository.findById(1).ifPresent(customer -> {
			log.info("Customer found with findById(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");
		});

		// fetch customers by apellidos
		log.info("Alumno found with findByApellidos('Bauer'):");
		log.info("--------------------------------------------");
		alumnosRepository.findByApellidos("Bauer").forEach(bauer -> {
			log.info(bauer.toString());
		});
		// for (TAlumno bauer : alumnosRepository.findByApellidos("Bauer")) {
		// log.info(bauer.toString());
		// }
		log.info("");
	}
	
	@Transactional()
	@PostConstruct
	void demo1() {
		
		dao.save(new TAlumno("Jack", "Bauer", "M", "E"));
	}
}
