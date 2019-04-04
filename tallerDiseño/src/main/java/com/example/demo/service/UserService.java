package com.example.demo.service;
import javax.annotation.PostConstruct;

import com.example.demo.model.*;
import com.example.demo.repository.*;
public class UserService{
    private UserRepository users;
    private PacientRepository pacients;
    @PostConstruct
    public void post(){
        Pacient p=pacients.findById("1234").get();
        User us=new User("login", p.getNames(), p.getLastNames(), "password".toCharArray(), p);
        p.setUser(us);
        us.setState(true);
        users.save(us);
    }
    public User getUser(String u){
        return users.findByLogin(u);
    }
    
}