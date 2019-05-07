package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.example.demo.model.MedicineInventory;

/**
 * InventoryDao
 */
public class InventoryDao implements IInventoryDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    @Override
    public void save(MedicineInventory entity) {
        manager.persist(entity);
    }

    @Override
    public void update(MedicineInventory entity) {
        manager.merge(entity);
    }

    @Override
    public void delete(MedicineInventory entity) {
        manager.remove(entity);
    }

    @Override
    public MedicineInventory findById(Integer id) {
        return manager.find(MedicineInventory.class, id);
    }

    
}