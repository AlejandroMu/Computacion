package com.taller.tallerjpa.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import com.taller.tallerjpa.model.Medicine;
import com.taller.tallerjpa.model.MedicineInventory;

import org.springframework.stereotype.Repository;

/**
 * InventoryDao
 */
@Repository
public class InventoryDao implements IInventoryDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    // @Transactional
    public void save(MedicineInventory entity) {
        entityManager.persist(entity);
    }

    @Override
    // @Transactional
    public void update(MedicineInventory entity) {
        entityManager.merge(entity);
    }

    @Override
    // @Transactional
    public void delete(MedicineInventory entity) {
        entityManager.remove(entity);
    }

    @Override
    // @Transactional

    public MedicineInventory findById(Long id) {
        return entityManager.find(MedicineInventory.class, id);
    }

    @Override
    // @Transactional
    public List<MedicineInventory> findAll() {
        String q = "Select i " + "From MedicineInventory i";
        return entityManager.createQuery(q).getResultList();
    }

    @Override
    // @Transactional
    public List<MedicineInventory> findByMedicine(Medicine med) {
        String jpql = "Select i " + "From MedicineInventory i "+ 
                      "Where i.medicine=(Select m From Medicine m Where m.id=" + med.getId() + ") "+
                      "Order By i.amountAvailable";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    @Override
    // @Transactional
    public List<MedicineInventory> findByDateExpiration(Date date) {
        String jpql = "Select i " + "From MedicineInventory i " + "Where i.medicine=:date";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("date", date, TemporalType.DATE);
        return query.getResultList();
    }
    @Override
    public void flush(){
        entityManager.flush();
    }

}