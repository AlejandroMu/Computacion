package com.example.demo.dao;

import java.util.List;

import javax.persistence.*;

import com.example.demo.model.Medicine;

import org.springframework.stereotype.Repository;

/**
 * MedicineDao
 */
@Repository
public class MedicineDao implements IMedicineDao {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    @Override
    public void save(Medicine entity) {
        manager.persist(entity);
    }

    @Override
    public void update(Medicine entity) {
        manager.merge(entity);
    }

    @Override
    public void delete(Medicine entity) {
        manager.remove(entity);
    }

    @Override
    public Medicine findById(Integer codigo) {
        return manager.find(Medicine.class, codigo);
    }

    @Override
    public List<Medicine> findAll() {
        String query="Select m From TMedicine m";
        return manager.createQuery(query).getResultList();
    }

    
}