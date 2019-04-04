package com.example.demo.service;

import javax.annotation.PostConstruct;

import com.example.demo.model.Pacient;
import com.example.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;

public class PacientService{
    @Autowired
    private PacientRepository pacients;  
    
    @PostConstruct
    public void post(){
        Pacient pacien=new Pacient("Juan", "Dias", "Sistemas");
        pacien.setDocument("document");
        pacien.setState(true);
        pacients.save(pacien);
        
    }
}