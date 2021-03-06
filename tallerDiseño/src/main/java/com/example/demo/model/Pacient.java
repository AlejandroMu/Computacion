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
	@OneToMany(fetch = FetchType.EAGER)
	private List<UrgencyAtention> atentions;
	@OneToMany(fetch = FetchType.EAGER)
	private List<Supply> supplys;
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	public String toString(){
		return document+" "+names+" "+lastNames;
	}
}
