package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.*;

import org.springframework.data.repository.CrudRepository;

public interface InventoryRepository extends CrudRepository<MedicineInventory,Integer>{
    List<Medicine> findByMedicine(Medicine med);
}