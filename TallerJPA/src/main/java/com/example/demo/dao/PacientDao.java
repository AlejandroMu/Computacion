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
    public Pacient findById(String codigo) {
        return entityManager.find(Pacient.class, codigo);
    }

    @Override
    public List<Pacient> findAll() {
        String jpql = "Select a from TPacient a";
        return entityManager.createQuery(jpql).getResultList();
    }

}