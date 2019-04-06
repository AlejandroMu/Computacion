package com.example.demo.service;
import javax.annotation.PostConstruct;

import com.example.demo.model.*;
import com.example.demo.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
@Service
public class UserService{
    @Autowired
    private UserRepository users;
    @Autowired
    private PacientService pacientService;
    @PostConstruct
    public void post(){
        Pacient p=pacientService.getPacient("1234");
        User us=new User("login@gmail.com", p.getNames(), p.getLastNames(), "password".toCharArray(), p);
        p.setUser(us);
        us.setState(true);
        users.save(us);
        
    }
    public User getUser(String u){
        return users.findByLogin(u);
    }
    
    
}