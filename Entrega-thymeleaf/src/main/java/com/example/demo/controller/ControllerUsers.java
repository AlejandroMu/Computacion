
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
public class ControllerUsers {
	@Autowired
	private UserRepository repositoryUser;
	

	@GetMapping("/")
	public String getIndex() {
		return "welcome";
	}
	
	
	@GetMapping("/crearUsuario")
	public String adicionarUsuario(Model mod) {
		User user=new User();
		addListModel(mod);
		mod.addAttribute("user", user);
		return "/user/crearUser.html";
	}
	public void addListModel(Model mod) {
		List<String> gene=new ArrayList<String>();
		List<String> roles=new ArrayList<String>();
		String[] generos=User.GENEROS;
		for (String string : generos) {
			gene.add(string);
			
		}
		String[] rols=User.ROL;
		for (String string : rols) {
			roles.add(string);
			
		}
		mod.addAttribute("roles", roles);
		mod.addAttribute("generos", gene);
		
	}

	@PostMapping("/saveCrear")
	public String saveCrear(@Validated @ModelAttribute User cn, BindingResult bin,Model mod) {
		if (bin.hasErrors()) {
			addListModel(mod);
			return "/user/crearUser.html";
		}
		
		repositoryUser.save(cn);
		return "redirect:/listar";
	}
	@GetMapping("/filtrar/{rol}")
	public String filtrar(@PathVariable("rol") String rol,Model m) {
		List<User> users=repositoryUser.findByRol(rol);
		m.addAttribute("users", users);
		m.addAttribute("filter", true);
		
		return "/user/listar.html";
	}
	@PostMapping("/saveEditar")
	public String saveEditar(@Validated @ModelAttribute User us, BindingResult bn) {
		if (bn.hasErrors()) {
			return "redirect:/editar/" + us.getCc();
		}
		repositoryUser.save(us);
		return "redirect:/listar";
	}

	@GetMapping("/editar/{id}")
	public String editarUsuario(Model mod, @PathVariable("id") Long id) {
		User n = repositoryUser.findById(id).get();
		mod.addAttribute("user", n);
		addListModel(mod);
		return "/user/editar.html";
	}

	@GetMapping("/borrar/{id}")
	public RedirectView borrarUsuario(@PathVariable String id) {
		repositoryUser.deleteById(Long.parseLong(id));
		return new RedirectView("/listar");
	}

	@GetMapping("/listar")
	public ModelAndView listarUsuario(Model m) {
		Iterable<User> iterable = repositoryUser.findAll();
		Iterator<User> it = iterable.iterator();
		List<User> lis = new ArrayList<User>();
		while (it.hasNext()) {
			lis.add(it.next());
		}
		m.addAttribute("filter", false);
		return new ModelAndView("/user/listar.html", "users", lis);
	}

}