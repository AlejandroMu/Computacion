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
	public Pacient findById(String codigo);
	public List<Pacient> findAll();
}