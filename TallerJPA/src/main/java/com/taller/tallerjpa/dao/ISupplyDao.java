package com.taller.tallerjpa.dao;

import java.util.List;

import com.taller.tallerjpa.model.Supply;


/**
 * ISupplyDao
 */
public interface ISupplyDao {

    public void save(Supply entity);
	public void update(Supply entity);
    public void delete(Supply entity);
    public Supply findById(Integer id);
    public void flush();
    public List<Supply> findByAmount(int min,int max);
	public List<Supply> findAll();
}