package com.taller.tallerjpa.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.taller.tallerjpa.dao.IPacientDao;
import com.taller.tallerjpa.model.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PacientService{
    @Autowired
    private IPacientDao pacients;  
    
    @PostConstruct
    @Transactional
    public void post(){
        // Pacient pacien=new Pacient("123412","Juan", "Dias", "Sistemas",true);
        // pacients.save(pacien);
        
    }
    public Pacient getPacient(String id){
        return pacients.findByDocument(id);
    }
    @Transactional
	public List<Pacient> getPacients() {
        List<Pacient> ret=new ArrayList<>();
        Iterable<Pacient> it=pacients.findAll();
        for (Pacient var : it) {
            ret.add(var);
        }
		return ret;
	}
}