package com.example.demo.service;

import java.util.*;

import javax.annotation.PostConstruct;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MedicineService{
    @Autowired
    private MedicineRepository medicines;
    @Autowired
    private InventoryService inventoryRepository;

    @PostConstruct
    public void post(){
        Medicine m1=new Medicine();
        m1.setAdministationType("via oral");
        m1.setContraIndications("ninguna");
        m1.setGenericName("Acetaminofén");
        m1.setLaboratory("genfar");
        List<MedicineInventory> l=inventoryRepository.getAll();
        for(MedicineInventory t: l){
            t.setMedicine(m1);
        }
        m1.setInventories(l);
        medicines.save(m1); 

    }
}