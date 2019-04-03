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
public class Pacient {
	@Id
	private String document;
	@NonNull
	private String names;
	@NonNull
	private String lastNames;
	@NonNull
	private String academicProgram;
	
	private boolean state;
	@OneToMany
	private List<UrgencyAtention> atentions;
	@OneToMany
	private List<Supply> supplys;
	@OneToOne
	private User user;
}
