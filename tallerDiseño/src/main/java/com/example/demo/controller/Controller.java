package com.example.demo.controller;


import com.example.demo.model.*;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


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
    public String valid(@Validated @ModelAttribute User us,BindingResult bin,Model m){
        if(bin.hasErrors()){
            return "autenticar.html";
        }
        User s=userService.getUser(us.getLogin());
        if(s!=null&&s.isState()){
            char[] p1=s.getPassword();
            char[] p2=us.getPassword();
            int max=p1.length;
            boolean same=max==p2.length;
            for (int i = 0; i < max&&same; i++) {
                same&=p1[i]==p2[i];
            }
            if(same){
                m.addAttribute("user", s);
            }else{
                m.addAttribute("conInco", true);
                m.addAttribute("msm", "Contraseña incorrecta");
                return "autenticar.html";
            }
            
        }else{
            m.addAttribute("sinPermisos", true);
            m.addAttribute("mes", "No tiene un usuario activo");
            return "autenticar.html";

        }
        return "redirect:/opciones";
    }
    @GetMapping("/opciones")
    public String opciones(@ModelAttribute User us){

        return "home";
    }
    @PostMapping(value="/evaluar")    
    public String evaluar(@RequestParam(value = "action", required = true) String action){
        if(action.equals("CrearAtencion")){

        }else if(action.equals("CrearModificar")){

        }else{
            
        }
        return "";
    }
}
