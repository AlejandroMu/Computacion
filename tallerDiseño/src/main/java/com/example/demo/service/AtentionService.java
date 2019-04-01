package com.example.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pacient;
import com.example.demo.model.Supply;
import com.example.demo.model.UrgencyAtention;
import com.example.demo.repository.AtentionRepository;
import com.example.demo.repository.PacientRepository;

@Service
public class AtentionService {
	@Autowired
	private AtentionRepository atentions;
	@Autowired
	private PacientRepository pacients;
	@Autowired
	private SupplyService supplyService;
	private int index;

	public boolean addAtention(UrgencyAtention atention) throws Exception {
		Pacient pacient = atention.getPacient();
		List<Supply> supplys = atention.getSupplys();
		Pacient p1=pacients.getPacient(pacient.getDocument());
		if (pacient.isState()&&p1!=null) {
			for (Supply supply : supplys) {
				if (!supply.getPacient().getDocument().equals(pacient.getDocument())) {
					throw new Exception("El paciente no coincide con el suministro");
				}
			}
			List<Supply> tmp=new ArrayList<Supply>();
			boolean fail=false;
			Exception e1=new Exception();
			for (Supply supply : supplys) {
				try {
				Supply n=supplyService.addSupply(supply);
				tmp.add(n);
				}catch (Exception e) {
					fail=true;
					e1=e;
					break;
				}
			}
			if(fail) {
				for (Supply supply : tmp) {
					supplyService.remove(supply);
				}
				throw e1;
			}
			atention.setId(index++);
			atention.setDateHour(new Date());
			atentions.addAtencion(atention);
			
		}else {
			throw new Exception("El paciente no esta activo");
		}
		return true;
	}
	public List<UrgencyAtention> getAtencions(){
		return atentions.getAllAtentions();
	}

}
