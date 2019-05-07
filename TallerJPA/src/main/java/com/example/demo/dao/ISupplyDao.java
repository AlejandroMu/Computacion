package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Supply;

/**
 * ISupplyDao
 */
public interface ISupplyDao {

    public void save(Supply entity);
	public void update(Supply entity);
    public void delete(Supply entity);
    public Supply findById(Integer id);

    public List<Supply> findByAmount(int min,int max);
}