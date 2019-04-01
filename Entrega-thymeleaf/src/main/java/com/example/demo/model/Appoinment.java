package com.example.demo.model;

import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Entity
@Data
public class Appoinment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@ManyToOne
	private User medic;
	@ManyToOne
	private User pacient;
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date date;
	@DateTimeFormat(pattern="HH:mm")
	private LocalTime hora;
	
	

}
