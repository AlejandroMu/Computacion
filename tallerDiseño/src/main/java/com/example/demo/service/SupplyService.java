package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.*;
@Service
public class SupplyService {

	@Autowired
	private SupplyRepository supplys;
	@Autowired
	private PacientRepository pacients;
	@Autowired
	private MedicineRepository medicines;

	
	private int currentId;
	
	public Supply addSupply(Supply newSupply)throws Exception {
		Pacient p=pacients.getPacient(newSupply.getPacient().getDocument());
		Medicine med=medicines.getMedicine(newSupply.getMedicine().getId());
		if(p!=null&&p.isState()) {
			if(med!=null){
				List<MedicineInventory> ientorynv=med.getInventories();
				int amountAviable=0;
				for (MedicineInventory medicineInventory : ientorynv) {
					amountAviable+=medicineInventory.getAmountAvailable();
				}				
				if(amountAviable>=newSupply.getAmount()) {
					newSupply.setId(currentId++);
					newSupply.setDateHour(new Date());
					supplys.addSupply(newSupply);
					int target=newSupply.getAmount();
					for (MedicineInventory medicineInventory : ientorynv) {
						int a=medicineInventory.getAmountAvailable();
						if(target==0) {
							break;
						}else if(a>=target) {
							medicineInventory.setAmountAvailable(a-target);
							break;
						}else {
							medicineInventory.setAmountAvailable(0);
							target-=a;

						}
					}
				}else{
					throw new Exception("El medicamento no tiene la cantidad necesaria");
				}
			}else {
				throw new Exception("El medicamento no existe");
			}
		}else {
			throw new Exception("El paciente no esta disponible");
		}
		return newSupply;
	}
	public Supply getSupply(int id) {
		Supply s=supplys.getSupply(id);
		return s;
	}
	public void remove(Supply supply) {
		supplys.remove(supply);
	}
	
	
}
