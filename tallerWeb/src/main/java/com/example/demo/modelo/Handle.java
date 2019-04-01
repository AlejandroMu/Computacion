package com.example.demo.modelo;

import java.util.*;

public class Handle {

	private List<Libro> books=new ArrayList<Libro>();
	
	public List<Libro> getBooks() {
		return books;
	}
	public void setBooks(List<Libro> libros) {
		this.books=libros;
	}
	public void addLibro(Libro l) {
		books.add(l);
	}
}
