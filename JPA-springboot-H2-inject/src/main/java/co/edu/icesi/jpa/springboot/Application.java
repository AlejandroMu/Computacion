package co.edu.icesi.jpa.springboot;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.jpa.springboot.model.TAlumno;
import co.edu.icesi.jpa.springboot.crud.AlumnosRepository;
import co.edu.icesi.jpa.springboot.crud.MateriasRepository;
import co.edu.icesi.jpa.springboot.dao.ITAlumnoDao;

@SpringBootApplication
@Configuration("/applicationContext.xml")

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}



}
