package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.demo.model.*;
import com.example.demo.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@SessionAttributes
@org.springframework.stereotype.Controller
public class Controller {
   
    @Autowired
    private AtentionService atentionService;

    
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @GetMapping("/")
    public String opciones() {       
        return "home";
    }

    @PostMapping(value = "/evaluar")
    public String evaluar(@RequestParam(value = "action", required = true) String action,RedirectAttributes red) {
        if (action.equals("Realizar Atención")) {
            UrgencyAtention atention=new UrgencyAtention();
            red.addFlashAttribute("atencion", atention);
            return "redirect:/atencion";
        } else if (action.equals("Medicamentos")) {
            return "redirect:/medicamentos";
        } else {
            ListUrgency lis=new ListUrgency();
            lis.setList(atentionService.getAtencions());
            red.addFlashAttribute("lis", lis);
            return "redirect:/listarAtenciones";

        }
    }
   
    

}
