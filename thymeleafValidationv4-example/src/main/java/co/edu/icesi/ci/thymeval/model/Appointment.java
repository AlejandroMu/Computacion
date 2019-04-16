package co.edu.icesi.ci.thymeval.model;

import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Entity
@Data
public class Appointment {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@NotBlank
	private String name;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Future
	@NotNull
	private LocalDate appDate;
	
	@DateTimeFormat(iso = ISO.TIME)
	@NotNull
	private LocalTime time;
	
	@ManyToOne
	private User patient;
	
	@ManyToOne
	private User doctor;
}
