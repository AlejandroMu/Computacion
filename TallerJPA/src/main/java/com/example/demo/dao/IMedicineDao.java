package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Medicine;

/**
 * IMedicineDao
 */
public interface IMedicineDao {

    public void save(Medicine entity);
	public void update(Medicine entity);
	public void delete(Medicine entity);
	public Medicine findById(Integer codigo);
	public List<Medicine> findAll();
}