package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UrgencyAtention {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NonNull
	private Date dateHour;
	
	@ManyToOne
	private Pacient pacient;
	@NonNull
	private String generalDescription;
	@NonNull
	private String procedureDone;
	private boolean transfer;
	
	private String placeTransfer;
	@NonNull
	private String observations;
	@NonNull
	@OneToMany
	private List<Supply> supplys;
}
