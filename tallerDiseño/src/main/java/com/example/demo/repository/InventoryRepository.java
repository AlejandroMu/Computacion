package com.example.demo.repository;

import com.example.demo.model.MedicineInventory;

import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<MedicineInventory,Integer>{

}