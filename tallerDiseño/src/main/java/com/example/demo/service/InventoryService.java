package com.example.demo.service;

import java.util.*;

import javax.annotation.PostConstruct;

import com.example.demo.repository.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class InventoryService{
    @Autowired
    private InventoryRepository inventories;

    @PostConstruct
    public void post(){
        MedicineInventory in1=new MedicineInventory();
        in1.setAmountAvailable(20);
        in1.setDateExpiration(new Date());
        in1.setLocation("location");
        inventories.save(in1);
    }
    public List<MedicineInventory> getAll(){
        Iterator<MedicineInventory> i=inventories.findAll().iterator();
        List<MedicineInventory> ret=new ArrayList<MedicineInventory>();
        while(i.hasNext()){
            ret.add(i.next());            
        }
        return ret;
    }
}