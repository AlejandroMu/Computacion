package com.taller.tallerjpa.service;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.taller.tallerjpa.dao.IInventoryDao;
import com.taller.tallerjpa.model.Medicine;
import com.taller.tallerjpa.model.MedicineInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    @Autowired
    private IInventoryDao inventories;
    @Autowired
    private MedicineService medicineService;

    @PostConstruct
    @Transactional
    public void post() {
        // MedicineInventory in1 = new MedicineInventory(20,"location",new Date());
        // Medicine medicin=medicineService.getMedicines().get(0);
       
        // in1.setMedicine(medicin);
        // inventories.save(in1);
    }
    public List<MedicineInventory> filtrar(Medicine med){
        return inventories.findByMedicine(med);
    }

    public List<MedicineInventory> filtrar(Date date){
        return inventories.findByDateExpiration(date);
    }

    public List<MedicineInventory> getAll() {
        Iterator<MedicineInventory> i = inventories.findAll().iterator();
        List<MedicineInventory> ret = new ArrayList<MedicineInventory>();
        while (i.hasNext()) {
            ret.add(i.next());
        }
        return ret;
    }

    public void saveAll(List<MedicineInventory> l) {
        for (MedicineInventory var : l) {
            inventories.save(var);

        }
    }

    public void addInventory(MedicineInventory inv) {
        inventories.save(inv);
    }
	public void update(MedicineInventory var) {
        inventories.update(var);
	}
	public void dalete(MedicineInventory var) {
        inventories.delete(var);
	}
}