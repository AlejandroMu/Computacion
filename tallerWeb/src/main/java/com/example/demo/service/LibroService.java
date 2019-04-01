package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Libro;

public interface LibroService {
	public List<Libro> encontrarLibros();
	public void guardarLibros(List<Libro> libros);
	public String getId();
	public List<Libro> encontrarLibros(String auth);

}
