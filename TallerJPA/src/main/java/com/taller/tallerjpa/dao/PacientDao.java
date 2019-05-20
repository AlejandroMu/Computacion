package com.taller.tallerjpa.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.taller.tallerjpa.model.Pacient;

import org.springframework.context.annotation.Scope;
import org.springframework.data.util.Pair;
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
    // @Transactional
    public void save(Pacient entity) {
        entityManager.persist(entity);
    }

    @Override
    // @Transactional
    public void update(Pacient entity) {
        entityManager.merge(entity);
    }

    @Override
    // @Transactional
    public void delete(Pacient entity) {
        entityManager.remove(entity);
    }

    @Override
    // @Transactional
    public List<Pacient> findAll() {
        String jpql = "Select a From Pacient a";
        return entityManager.createQuery(jpql).getResultList();
    }

    @Override
    // @Transactional
    public Pacient findByDocument(String doc) {
        return entityManager.find(Pacient.class, doc);
    }

    @Override
    // @Transactional
    public List<Pacient> findByName(String name) {
        String query = "Select t From Pacient t Where t.name='" + name + "'";
        Query q = entityManager.createQuery(query);
        List<Pacient> ret = q.getResultList();
        return ret;
    }

    @Override
    // @Transactional
    public List<Pacient> findByLastName(String lastName) {
        String query = "Select t From Pacient t Where t.lastName='" + lastName + "'";
        Query q = entityManager.createQuery(query);
        List<Pacient> ret = q.getResultList();
        return ret;
    }

    @Override
    // @Transactional
    public List<Pair<Pacient, Long>> findAllWithAtentions() {
        String query = "Select p," + "(Select Count(a) " + "From Atencion a Where a.pacient=p) " + "From Pacient p "
                + "Order By p.document";
        List<Object[]> tmp = entityManager.createQuery(query).getResultList();
        List<Pair<Pacient, Long>> ret = new ArrayList<Pair<Pacient, Long>>();
        for (Object[] var : tmp) {
            Pair<Pacient, Long> pair = Pair.of((Pacient) var[0], (long) var[1]);
            ret.add(pair);
        }

        return ret;
    }

    @Override
    // @Transactional
    public List<Pacient> findLastAtencion() {
        String query = "Select p " + "From Pacient p " + "Where (Select COUNT(a) " + "From Atencion a "
                + "Where  a.pacient=p AND DATEDIFF(day,a.dateHour,SYSDATE())<=30)>=2";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void flush() {
        entityManager.flush();
    }

}