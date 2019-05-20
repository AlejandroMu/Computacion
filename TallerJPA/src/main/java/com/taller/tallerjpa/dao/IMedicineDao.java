package com.taller.tallerjpa.dao;

import java.util.List;

import com.taller.tallerjpa.model.Medicine;


/**
 * IMedicineDao
 */
public interface IMedicineDao {

    public void save(Medicine entity);
	public void update(Medicine entity);
	public void delete(Medicine entity);
	public Medicine findById(Integer codigo);
	public List<Medicine> findAll();
	public List<Medicine> findByInventory();
	public long amountAvailable(Medicine med);
	public void flush();
}