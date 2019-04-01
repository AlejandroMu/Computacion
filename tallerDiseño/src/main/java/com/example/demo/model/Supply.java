package com.example.demo.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data 
@NoArgsConstructor
@RequiredArgsConstructor
public class Supply {
	private int id;
	@NonNull
	private Medicine medicine;
	private int amount; 
	@NonNull
	private Pacient pacient; 
	@NonNull 
	private Date dateHour; 
	@NonNull 
	private String observation; 
	@NonNull
	private String pathology; 
	@NonNull 
	private UrgencyAtention atencion;
	
}
