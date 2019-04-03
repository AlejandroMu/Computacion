package com.example.demo.repository;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Supply;

@Repository
public interface SupplyRepository extends CrudRepository<Supply,Integer> {
	
}
