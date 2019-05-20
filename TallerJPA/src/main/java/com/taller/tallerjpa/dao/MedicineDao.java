package com.taller.tallerjpa.dao;

import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.taller.tallerjpa.model.Medicine;

import org.springframework.stereotype.Repository;

/**
 * MedicineDao
 */
@Repository
public class MedicineDao implements IMedicineDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    // @Transactional
    public void save(Medicine entity) {
        entityManager.persist(entity);
    }

    @Override
    // @Transactional
    public void update(Medicine entity) {
        entityManager.merge(entity);
    }

    @Override
    // @Transactional
    public void delete(Medicine entity) {
        entityManager.remove(entity);
    }

    @Override
    // @Transactional
    public Medicine findById(Integer codigo) {
        Medicine ret = entityManager.find(Medicine.class, codigo);
        entityManager.flush();
        return ret;
    }

    @Override
    // @Transactional
    public List<Medicine> findAll() {
        String query = "Select m From Medicine m";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    // @Transactional
    public List<Medicine> findByInventory() {
        String query = "Select m " + "From Medicine m " + "Where (Select Count(i) " + "From MedicineInventory i "
                + "Where i.medicine=m AND (i.amountAvailable BETWEEN 1 AND 10))>0";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    // @Transactional
    public long amountAvailable(Medicine med) {
        String jpl="Select Sum(i.amountAvailable) "+
                    "From MedicineInventory i "+
                    "Where i.medicine=(Select m From Medicine m Where m.id="+med.getId()+")";
        return (long)entityManager.createQuery(jpl).getResultList().get(0);
    }

    @Override
    public void flush() {
        entityManager.getTransaction().commit();
    }

}