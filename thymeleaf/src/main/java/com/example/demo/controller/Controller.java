
package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@org.springframework.stereotype.Controller
public class Controller {
	@Autowired
	private UserRepository repository;
	
	@GetMapping("/")
	public String getIndex() {
		return "redirect:/listar";
	}
	
	@GetMapping("/crear")
	public String adicionarUsuario(Model mod) {
		User n = new User();
		mod.addAttribute("user", n);
		return "crear.html";
	}

	@PostMapping("/saveCrear")
	public String saveCrear(@Validated @ModelAttribute User us,BindingResult bin) {
		if(bin.hasErrors()) {
			return "crear.html";
		}
		repository.save(us);
		return "redirect:/listar";
	}
	
	@PostMapping("/saveEditar")
	public String saveEditar(@Validated @ModelAttribute User us,BindingResult bn) {
		if(bn.hasErrors()) {
			return "redirect:/editar/"+us.getCc();
		}
		System.out.println(us.getCc());
		repository.save(us);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editarUsuario(Model mod,@PathVariable("id") Long id) {
		User n = repository.findById(id).get();
		mod.addAttribute("user", n);
		return "editar.html";
	}

	@GetMapping("/borrar/{id}")
	public RedirectView borrarUsuario(@PathVariable String id) {
		repository.deleteById(Long.parseLong(id));
		return new RedirectView("/listar");
	}

	@GetMapping("/listar")
	public ModelAndView listarUsuario(Model mod) {
		Iterable<User> iterable =	 repository.findAll();
		Iterator<User> it = iterable.iterator();
		List<User> lis = new ArrayList<User>();
		while (it.hasNext()) {
			lis.add(it.next());
		}
		return new ModelAndView("listar.html", "users", lis);
	}

}