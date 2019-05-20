package com.taller.tallerjpa.dao;

import java.util.Date;
import java.util.List;

import com.taller.tallerjpa.model.Atencion;


/**
 * IAtencionDao
 */
public interface IAtencionDao {

    public void save(Atencion entity);
	public void update(Atencion entity);
    public void delete(Atencion entity);
    public Atencion findById(Integer id);
    public List<Atencion> findAll();
    public List<Atencion> findByDates(Date f1,Date f2);
    public List<Atencion> findByDateHour(Date date);
    public void flush();
}