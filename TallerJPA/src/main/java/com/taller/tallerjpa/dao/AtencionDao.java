package com.taller.tallerjpa.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.transaction.Transactional;

import com.taller.tallerjpa.model.Atencion;

import org.springframework.stereotype.Repository;

/**
 * AtencionDao
 */
@Repository
public class AtencionDao implements IAtencionDao {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	@Override
	// @Transactional
	public void save(Atencion entity) {
		entityManager.persist(entity);
	}

	@Override
	// @Transactional
	public void update(Atencion entity) {
		entityManager.merge(entity);
	}

	@Override
	// @Transactional
	public void delete(Atencion entity) {
		entityManager.remove(entity);
	}

	@Override
	// @Transactional
	public Atencion findById(Integer id) {
		return entityManager.find(Atencion.class, id);
	}

	@Override
	// @Transactional
	public List<Atencion> findAll() {
		String query = "Select t From Atencion t";
		return entityManager.createQuery(query).getResultList();
	}

	@Override
	// @Transactional
	public List<Atencion> findByDates(Date f1, Date f2) {
		String que = "Select t From Atencion t Where t.dateHour BETWEEN :inferior AND :superior";
		Query query = entityManager.createQuery(que);
		query.setParameter("inferior", f1, TemporalType.DATE);
		query.setParameter("superior", f2, TemporalType.DATE);
		return query.getResultList();
	}

	@Override
	// @Transactional
	public List<Atencion> findByDateHour(Date date) {
		String queryJ = "Select a " + "From Atencion a " + "Where a.dateHour=:date";
		Query query = entityManager.createQuery(queryJ);
		query.setParameter("date", date, TemporalType.DATE);
		return query.getResultList();
	}

	@Override
	// @Transactional
	public void flush() {
		entityManager.flush();
	}

}