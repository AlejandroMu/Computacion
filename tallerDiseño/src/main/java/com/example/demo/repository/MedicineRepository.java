package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Medicine;

@Repository
public class MedicineRepository {
	private Map<Integer, Medicine> medicine;

	public MedicineRepository() {
		medicine = new HashMap<Integer, Medicine>();
	}
	
	public void addMedicine(Medicine med) {
		medicine.put(med.getId(),med);
	}
	public Medicine getMedicine(int id) {
		return medicine.get(id);
	}
	public List<Medicine> getAllMedicine(){
		return new ArrayList<Medicine>(medicine.values());
	}

}
