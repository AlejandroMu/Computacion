package com.taller.tallerjpa.service;

import java.util.*;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.tallerjpa.dao.*;
import com.taller.tallerjpa.model.*;

@Service
public class SupplyService {

	@Autowired
	private ISupplyDao supplys;
	@Autowired
	private IPacientDao pacients;
	@Autowired
	private MedicineService medicines; 

	@Transactional(value = TxType.REQUIRES_NEW,rollbackOn = {Exception.class})
	public Supply addSupply(Supply newSupply)throws Exception {
		Pacient p=newSupply.getPacient()!=null?pacients.findByDocument(newSupply.getPacient().getDocument()):null;
		Medicine med=newSupply.getMedicine()!=null?medicines.findById(newSupply.getMedicine().getId()):null;
		
		if(p!=null&&p.isState()) {
			if(med!=null){
				long amountAviable=medicines.amountAvailable(med);		
				long target=newSupply.getAmount();
				newSupply.setMedicine(med);
				newSupply.setPacient(p);
				if(amountAviable>=target) {
					supplys.save(newSupply);
					medicines.reduceInventory(med, target);
				}else{
					throw new Exception("El medicamento "+ med.getGenericName() + " solo dispone de "+amountAviable+" unidades");
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
		Supply s=supplys.findById(id);
		return s;
	}
	public void remove(Supply supply) {
		supplys.delete(supply);
	}
	
	
}
