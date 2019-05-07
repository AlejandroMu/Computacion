package com.example.demo.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.example.demo.model.Supply;

/**
 * SupplyDao
 */
public class SupplyDao implements ISupplyDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    @Override
    public void save(Supply entity) {
        manager.persist(entity);
    }

    @Override
    public void update(Supply entity) {
        manager.merge(entity);
    }

    @Override
    public void delete(Supply entity) {
        manager.remove(entity);
    }

    @Override
    public Supply findById(Integer id) {
        return manager.find(Supply.class, id);
    }

    @Override
    public List<Supply> findByAmount(int min, int max) {
        String query="Select t From TSupply t Where t.amount BETWEEN "+min+" AND "+max;
        return manager.createQuery(query).getResultList();
    }

    
}