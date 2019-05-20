package com.taller.tallerjpa.service;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.taller.tallerjpa.dao.IMedicineDao;
import com.taller.tallerjpa.model.Medicine;
import com.taller.tallerjpa.model.MedicineInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class MedicineService{
    @Autowired
    private IMedicineDao medicines;
    @Autowired
    private InventoryService inventoryService;
    

    @PostConstruct
    @Transactional
    public void post(){
        // Medicine m1=new Medicine();
        // m1.setName("Acetaminof");
        // m1.setAdministationType("via oral");
        // m1.setIndications("ninguna");
        // m1.setContraIndications("ninguna");
        // m1.setGenericName("Acetaminofén");
        // m1.setLaboratory("genfar");
        // medicines.save(m1); 

    }
    @Transactional
	public List<Medicine> getMedicines() {
        List<Medicine> ret=new ArrayList<Medicine>();
        Iterable<Medicine> it=medicines.findAll();
        for (Medicine var : it) {
            ret.add(var);
        }
		return ret;
    }
    
    public void addMedicine(Medicine med){
         medicines.save(med);
    }
    @Transactional
	public List<Medicine> filtrar(Date date) {
        List<MedicineInventory> inventories=inventoryService.filtrar(date);
        HashSet<Medicine> medicines=new HashSet<>();
        for (MedicineInventory inv : inventories) {
            medicines.add(inv.getMedicine());
        }
        List<Medicine> med=new ArrayList<>();
        medicines.forEach(x->med.add(x));
		return med;
    }
    public long amountAvailable(Medicine med){
        return medicines.amountAvailable(med);
    }
    @Transactional(value = TxType.REQUIRES_NEW)
    public void reduceInventory(Medicine med,long a){
        List<MedicineInventory> inventories=inventoryService.filtrar(med);
        for (MedicineInventory var : inventories) {
            long m=var.getAmountAvailable();
            if(m>a){
                var.setAmountAvailable(m-a);
                inventoryService.update(var);
                break;
            }else{
                a-=m;
                inventoryService.dalete(var);
            }           
        }

    }
    public Medicine findById(int id){
        return medicines.findById(id);
    }
}