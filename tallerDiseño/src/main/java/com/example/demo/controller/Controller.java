package com.example.demo.controller;

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

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private UserService userService;
    @Autowired
    private AtentionService atentionService;
    @Autowired
    private MedicineService medicineService;
    @Autowired
    private PacientService pacientService;

    private User sesion;
    

    @GetMapping("/")
    public String inicio(Model m) {
        if (sesion != null) {
            return "redirect:/home";
        }
        m.addAttribute("user", new User());
        return "autenticar.html";
    }

    @PostMapping("/validar")
    public String valid(@Validated @ModelAttribute User us, BindingResult bin, Model m) {
        if (bin.hasErrors()) {
            return "autenticar.html";
        }
        User s = userService.getUser(us.getLogin());
        if (s != null && s.isState()) {
            char[] p1 = s.getPassword();
            char[] p2 = us.getPassword();
            int max = p1.length;
            boolean same = max == p2.length;
            for (int i = 0; i < max && same; i++) {
                same &= p1[i] == p2[i];
            }
            if (same) {
                sesion = s;
            } else {
                m.addAttribute("conInco", true);
                m.addAttribute("msm", "Contraseña incorrecta");
                return "autenticar.html";
            }

        } else {
            m.addAttribute("sinPermisos", true);
            m.addAttribute("mes", "No tiene un usuario activo");
            return "autenticar.html";

        }
        return "redirect:/opciones";
    }

    @GetMapping("/opciones")
    public String opciones(Model m) {
        if (sesion == null) {
            return "redirect:/";
        }
        return "home";
    }

    @PostMapping(value = "/evaluar")
    public String evaluar(@RequestParam(value = "action", required = true) String action) {
        if (sesion == null) {
            return "redirect:/";
        }
        if (action.equals("Realizar Atención")) {
            return "redirect:/atencion";
        } else if (action.equals("Perfil")) {
            return "redirect:/modificar";
        } else {
            return "redirect:/suministro";

        }
    }

    @GetMapping(value = "/atencion")
    public String getMethodName(Model model) {
        if (sesion == null) {
            return "redirect:/";
        }
        UrgencyAtention atec=new UrgencyAtention();
        atec.setDateHour(new Date());
        model.addAttribute("atencion", atec);
        addPacients(model);
        return "crearAtencion";
    }

    @PostMapping("/atencion")
    public String saveAtencion(@RequestParam(value = "action", required = true) String action,
            @ModelAttribute UrgencyAtention a, Model m) {
        if (sesion == null) {
            return "redirect:/";
        }
        if (action.equals("Guardar")) {
            try {
                atentionService.addAtention(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
           
            return "redirect:/suministro";
        }
        return "redirect:/opciones";
    }

    @GetMapping(value = "/modificar")
    public String editar(Model m) {
        if (sesion == null) {
            return "redirect:/";
        }
        m.addAttribute("user", sesion);
        return "editarUsuario";
    }

    @GetMapping(value = "/suministro")
    public String agregarSuministro(Model m) {
        if (sesion == null) {
            return "redirect:/";
        }
        Supply supl = new Supply();
        m.addAttribute("supply", supl);
        addMedicine(m);
        
        return "suministro.html";
    }

    @PostMapping(value = "/suministro")
    public String saveSupply(Model m,@ModelAttribute(name = "supply") Supply s) {
                if(sesion==null){
                    return "redirect:/";
                }
               
        return "redirect:/";
    }

    public void addMedicine(Model m){
    	List<Medicine> medi=medicineService.getMedicines();
        m.addAttribute("medicines", medi);
    }
    public void addPacients(Model m){
        m.addAttribute("pacients", pacientService.getPacients());
    }

}
