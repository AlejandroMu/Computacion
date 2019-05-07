package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.example.demo.model.UrgencyAtention;

/**
 * AtencionDao
 */
public class AtencionDao implements IAtencionDao{

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

	@Override
	public void save(UrgencyAtention entity) {
		manager.persist(entity);
	}

	@Override
	public void update(UrgencyAtention entity) {
		manager.merge(entity);
	}

	@Override
	public void delete(UrgencyAtention entity) {
		manager.remove(entity);
	}

	@Override
	public UrgencyAtention findById(Integer id) {
		return manager.find(UrgencyAtention.class, id);
	}

	@Override
	public List<UrgencyAtention> findAll() {
        String query="Select t From TAtencion t";
		return manager.createQuery(query).getResultList();
	}

	@Override
	public List<UrgencyAtention> findByDates(Date f1, Date f2) {
		String query="Select t From TAtencion t Where t.dateHour BETWEEN "+f1+" AND "+f2;
		return manager.createQuery(query).getResultList();
	}

    
}