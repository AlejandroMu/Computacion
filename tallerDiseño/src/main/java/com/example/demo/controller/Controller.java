package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
public class Controller{
    @Autowired
    private UserService userService;
    

    @GetMapping("/")
    public String inicio(Model m){
        m.addAttribute("user", new User());
        return "autenticar.html";
    }
    @PostMapping("/validar")
    public String valid(@Validated @ModelAttribute User us,BindingResult bin){
        if(bin.hasErrors()){
            return "autenticar.html";
        }

        return "redirect:/";
    }
}
