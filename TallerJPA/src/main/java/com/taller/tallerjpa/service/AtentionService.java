package com.taller.tallerjpa.service;

import java.util.*;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller.tallerjpa.dao.*;
import com.taller.tallerjpa.model.*;

@Service
public class AtentionService {
	@Autowired
	private IAtencionDao atentions;
	@Autowired
	private IPacientDao pacients;
	@Autowired
	private SupplyService supplyService;

	@Transactional
	public boolean addAtention(Atencion atention) throws Exception {
		Pacient pacient = atention.getPacient();
		List<Supply> supplys = atention.getSupplys();
		Pacient p1 = pacients.findByDocument(pacient.getDocument());
		if (pacient.isState() && p1 != null) {
			if (supplys != null) {
				for (Supply supply : supplys) {
					if (!supply.getPacient().getDocument().equals(pacient.getDocument())) {
						throw new Exception("El paciente no coincide con el suministro");
					}
				}
				atentions.save(atention);
				for (Supply supply : supplys) {
					supplyService.addSupply(supply);
				}

			}

		} else {
			throw new Exception("El paciente no esta activo");
		}
		return true;
	}

	public List<Atencion> getAtencions() {

		return atentions.findAll();
	}

	public List<Atencion> getAtencions(Date date) {
		return atentions.findByDateHour(date);
	}

}
