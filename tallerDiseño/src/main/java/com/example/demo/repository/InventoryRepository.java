package com.example.demo.repository;

import java.util.*;

import com.example.demo.model.*;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<MedicineInventory, Integer> {
    List<MedicineInventory> findByMedicine(Medicine med);
    List<MedicineInventory> findByDateExpiration(Date date);
}