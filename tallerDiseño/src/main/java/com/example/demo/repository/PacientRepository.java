package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Pacient;

@Repository
public class PacientRepository {
	private Map<String, Pacient> pacients;

	public PacientRepository() {
		pacients = new HashMap<String, Pacient>();
	}
	
	public void addPacient(Pacient pacient) {
		pacients.put(pacient.getDocument(), pacient);
	}
	public Pacient getPacient(String document) {
		return pacients.get(document);
	}
	public List<Pacient> getAllPacients(){
		return new ArrayList<Pacient>(pacients.values());
	}
}
