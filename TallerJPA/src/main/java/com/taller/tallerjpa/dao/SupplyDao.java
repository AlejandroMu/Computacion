package com.taller.tallerjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

import com.taller.tallerjpa.model.Supply;

import org.springframework.stereotype.Repository;

/**
 * SupplyDao
 */
@Repository
public class SupplyDao implements ISupplyDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    // @Transactional
    public void save(Supply entity) {
        entityManager.persist(entity);
    }

    @Override
    // @Transactional
    public void update(Supply entity) {
        entityManager.merge(entity);
    }

    @Override
    // @Transactional
    public void delete(Supply entity) {
        entityManager.remove(entity);
    }

    @Override
    // @Transactional
    public Supply findById(Integer id) {
        return entityManager.find(Supply.class, id);
    }

    @Override
    // @Transactional
    public List<Supply> findByAmount(int min, int max) {
        String query="Select t From Supply t Where t.amount BETWEEN "+min+" AND "+max;
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    // @Transactional
    public List<Supply> findAll() {
        String q="Select s From Supply s";
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

    
}