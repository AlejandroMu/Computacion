package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;
@Repository
public interface AppoinmentRepository extends CrudRepository<Appoinment, Long> {
	public List<Appoinment> findByPacient(User pac);
	public List<Appoinment> findByMedic(User medic);
	

}
