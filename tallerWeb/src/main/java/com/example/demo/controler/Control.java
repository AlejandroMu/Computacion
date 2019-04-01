package com.example.demo.controler;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.modelo.*;
import com.example.demo.service.LibroService;

@Controller
public class Control {
	@Autowired
	private LibroService service;
	
	@GetMapping("/")
	public String startPage() {
		return "index";
	}

	

	@GetMapping("/crear")
	public String crearLibro(Model model) {
		Handle han=new Handle();
		ArrayList<Libro> libros=new ArrayList<>();
		for (int i = 0; i <=1; i++) {
			Libro lib=new Libro();
			libros.add(lib);
		}
		han.setBooks(libros);
		model.addAttribute("form",han);	
		return "crearForm.html";
	}
	@GetMapping("/listar")
	public String mostrar(Model model) {
		List<Libro> books=service.encontrarLibros();
		model.addAttribute("books",books);
		return "listarForm";
	}
	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Handle han) {
		service.guardarLibros(han.getBooks());
		return "index";
	}
	@GetMapping("/editar")
	public String editar(Model model) {
		List<Libro> books=service.encontrarLibros();
		model.addAttribute("books",books);
		return "editarForm";
	}
	@GetMapping("/editar/requ")
	public String editarR(Model model,@RequestParam String author) {
		List<Libro> books=service.encontrarLibros(author);
		model.addAttribute("books",books);
		return "editarForm";
	}
	@GetMapping("/editar/{author}")
	public String editar(Model model,@PathVariable String author) {
		List<Libro> books=service.encontrarLibros(author);
		model.addAttribute("books",books);
		return "editarForm";
	}
}
