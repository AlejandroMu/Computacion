package com.taller.tallerjpa.dao;

import java.util.Date;
import java.util.List;

import com.taller.tallerjpa.model.Medicine;
import com.taller.tallerjpa.model.MedicineInventory;

/**
 * IInventoryDao
 */
public interface IInventoryDao {

    public void save(MedicineInventory entity);
	public void update(MedicineInventory entity);
    public void delete(MedicineInventory entity);
    public MedicineInventory findById(Long id);
	public List<MedicineInventory> findAll();
	public List<MedicineInventory> findByMedicine(Medicine med);
	public List<MedicineInventory> findByDateExpiration(Date date);
	public void flush();
}