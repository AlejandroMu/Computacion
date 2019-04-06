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
public class Supply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	private Medicine medicine;
	private Integer amount; 
	
	@ManyToOne
	private Pacient pacient; 
	
	private Date dateHour; 
	
	private String observation; 
	
	private String pathology; 
	
	@ManyToOne
	private UrgencyAtention atencion;
	
}
