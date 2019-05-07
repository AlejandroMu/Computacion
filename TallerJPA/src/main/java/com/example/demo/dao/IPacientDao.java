package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Pacient;

/**
 * IPacientDao
 */
public interface IPacientDao {

    public void save(Pacient entity);
	public void update(Pacient entity);
	public void delete(Pacient entity);
	public Pacient findByDocumment(String doc);
	public List<Pacient> findByName(String name);
	public List<Pacient> findByLastName(String lastName);
	public List<Pacient> findAll();
	public List<Pacient> findAllWithAtentions();
}