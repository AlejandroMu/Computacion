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
	private Integer id;
	
	@ManyToOne
	private Medicine medicine;
	@NonNull
	private Integer amount; 
	
	@ManyToOne
	private Pacient pacient; 
	@NonNull
	private Date dateHour; 
	@NonNull
	private String observation; 
	@NonNull
	private String pathology; 
	
	@ManyToOne
	private UrgencyAtention atencion;
	
}
