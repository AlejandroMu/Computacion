package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Entity
@Data
public class User {
	public static final String ROL[]= {"Medico","Paciente"};
	public static final String GENEROS[]= {"Masculino","Femenino"};

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cc;
	@NotBlank(message="{name.blank}")
	@Size(min=3, message="{name.size}")
	private String name;
	@NotBlank(message="{correo.blank}")
	@Email(message="{correo.invalido}")
	private String mail;
	
	private String rol;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaNacimiento;
	private String genero;
	
	public String toString() {
		return cc+"";
	}

}
