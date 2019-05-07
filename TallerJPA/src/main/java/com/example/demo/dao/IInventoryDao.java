package com.example.demo.dao;

import com.example.demo.model.MedicineInventory;

/**
 * IInventoryDao
 */
public interface IInventoryDao {

    public void save(MedicineInventory entity);
	public void update(MedicineInventory entity);
    public void delete(MedicineInventory entity);
    public MedicineInventory findById(Integer id);

}