package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Appoinment;
import com.example.demo.model.User;
import com.example.demo.repository.AppoinmentRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ControllerAppoinment {
	@Autowired
	private AppoinmentRepository repositoryApp;
	@Autowired
	private UserRepository users;

	@GetMapping("/crearCita")
	public String addAppoinment(Model mod) {
		Appoinment ap=new Appoinment();
		
		addUsersM(mod);
		mod.addAttribute("appoinment", ap);
		mod.addAttribute("editar", false);
		return "/appoinment/crearApploinment";
	}

	@PostMapping("/saveApp")
	public String save(@ModelAttribute Appoinment c) {
		
		repositoryApp.save(c);
		return "redirect:/listarApp";
	}
	@GetMapping("/filtrarCitas/{id}")
	public ModelAndView filtrarCitas(@PathVariable String id) {
		Long l=Long.parseLong(id);
		User pac=users.findById(l).get();
		if(pac.getRol().equals(User.ROL[1])) {
			return new ModelAndView("/appoinment/listarAp","apploinments",repositoryApp.findByPacient(pac));	
		}
		return new ModelAndView("/appoinment/listarAp","apploinments",repositoryApp.findByMedic(pac));
	}

	@GetMapping("/listarApp")
	public String listar(Model m) {
		m.addAttribute("apploinments", repositoryApp.findAll());
		return "/appoinment/listarAp";
	}

	@GetMapping("/detalles/{id}")
	public ModelAndView detalles(@PathVariable String id) {
		User u = users.findById(Long.parseLong(id)).get();
		List<User> l = new ArrayList<User>();
		l.add(u);
		return new ModelAndView("/user/listar.html", "users", l);
	}

	@GetMapping("/editarApp/{id}")
	public String editarApp(@PathVariable String id, Model mod) {
		Appoinment ap = repositoryApp.findById(Long.parseLong(id)).get();
		mod.addAttribute("appoinment", ap);
		addUsersM(mod);
		mod.addAttribute("editar", true);

		return "/appoinment/crearApploinment";
	}

	public void addUsersM(Model mod) {
		mod.addAttribute("medicos", users.findByRol(User.ROL[0]));
		mod.addAttribute("pacientes", users.findByRol(User.ROL[1]));
	}
	@GetMapping("/deleteApp/{id}")
	public String deleteAppoinment(@PathVariable String id) {
		Long idL=Long.parseLong(id);
		repositoryApp.deleteById(idL);
		return "redirect:/listarApp";
	}
}
