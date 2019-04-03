package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data 
@NoArgsConstructor
@RequiredArgsConstructor
public class Supply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	@ManyToOne
	private Medicine medicine;
	private int amount; 
	@NonNull
	@ManyToOne
	private Pacient pacient; 
	@NonNull 
	private Date dateHour; 
	@NonNull 
	private String observation; 
	@NonNull
	private String pathology; 
	@NonNull 
	@ManyToOne
	private UrgencyAtention atencion;
	
}
