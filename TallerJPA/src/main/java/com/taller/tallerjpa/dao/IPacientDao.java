package com.taller.tallerjpa.dao;

import java.util.List;

import com.taller.tallerjpa.model.Pacient;

import org.springframework.data.util.Pair;


/**
 * IPacientDao
 */
public interface IPacientDao {

    public void save(Pacient entity);
	public void update(Pacient entity);
	public void delete(Pacient entity);
	public Pacient findByDocument(String doc);
	public List<Pacient> findByName(String name);
	public List<Pacient> findByLastName(String lastName);
	public List<Pacient> findAll();
	public List<Pair<Pacient,Long>> findAllWithAtentions();
	public List<Pacient> findLastAtencion();
	public void flush();
}