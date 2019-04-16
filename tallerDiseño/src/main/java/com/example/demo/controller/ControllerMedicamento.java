package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerMedicamento{
    
    @GetMapping(value="/medicamentos")
    public String medicamentos() {
        return new String();
    }

}