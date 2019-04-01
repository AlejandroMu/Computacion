package com.example.demo.repository;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Supply;

@Repository
public class SupplyRepository {
	private Map<Integer, Supply> supplys;

	public SupplyRepository() {
		supplys = new HashMap<Integer, Supply>();
	}
	public Supply getSupply(int id) {
		return supplys.get(id);
	}
	public void addSupply(Supply newSupply) {
		supplys.put(newSupply.getId(),newSupply);
	}
	public List<Supply> getAllSupply() {
		return new ArrayList<Supply>(supplys.values());
	}
	public void remove(Supply supply) {
		supplys.remove(supply.getId());
	}
}
