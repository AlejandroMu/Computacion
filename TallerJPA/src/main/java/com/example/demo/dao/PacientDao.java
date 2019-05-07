package com.example.demo.dao;

import java.util.List;

import javax.persistence.*;

import com.example.demo.model.Pacient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.*;

/**
 * PacientDao
 */
@Repository
@Scope("singleton")
public class PacientDao implements IPacientDao {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
    public void save(Pacient entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(Pacient entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(Pacient entity) {
        entityManager.remove(entity);
    }

    @Override
    public List<Pacient> findAll() {
        String jpql = "Select a From TPacient a";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    public Pacient findByDocumment(String doc) {
        return entityManager.find(Pacient.class, doc);
    }

    @Override
    public List<Pacient> findByName(String name) {
        String query="Select t From TPacient t Where t.name='"+name+"'";
        Query q= entityManager.createQuery(query);
        List<Pacient> ret=q.getResultList();
        return ret;
    }

    @Override
    public List<Pacient> findByLastName(String lastName) {
        String query="Select t From TPacient t Where t.lastName='"+lastName+"'";
        Query q= entityManager.createQuery(query);
        List<Pacient> ret=q.getResultList();
        return ret;
    }

    @Override
    public List<Pacient> findAllWithAtentions() {
        String query="Select t,Count(r)"+
                     "From TPacient t,TAtencion a"+
                     "Where t.document=a.pacient";
        return null;
    }



}