package com.example.demo.dao;

import java.util.Date;
import java.util.List;

import com.example.demo.model.UrgencyAtention;

/**
 * IAtencionDao
 */
public interface IAtencionDao {

    public void save(UrgencyAtention entity);
	public void update(UrgencyAtention entity);
    public void delete(UrgencyAtention entity);
    public UrgencyAtention findById(Integer id);
    public List<UrgencyAtention> findAll();
    public List<UrgencyAtention> findByDates(Date f1,Date f2);
}