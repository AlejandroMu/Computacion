package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
@Data
@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cc;
	@NotBlank(message="{name.blank}")
	@Size(min=3, message="{name.size}")
	private String name;
	@NotBlank(message="{correo.blank}")
	@Email(message="{correo.invalido}")
	private String mail;

}
