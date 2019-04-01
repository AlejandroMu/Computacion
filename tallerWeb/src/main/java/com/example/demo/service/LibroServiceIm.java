package com.example.demo.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.modelo.Libro;

@Service
public class LibroServiceIm implements LibroService {

	private Map<String, Libro> libros = new HashMap<String, Libro>();
	private int index = 0;
	public LibroServiceIm() {
		Libro tmp=new Libro();
		tmp.setAuthor("Miguel");
		tmp.setTitle("Don quijote");
		tmp.setId(""+index++);
		libros.put(tmp.getId(), tmp);
		Libro tmp1=new Libro();
		tmp1.setAuthor("Gabriel");
		tmp1.setTitle("cien años de soledad");
		tmp1.setId(""+index++);
		libros.put(tmp1.getId(), tmp1);
		Libro tmp2=new Libro();
		tmp2.setAuthor("Gabriel");
		tmp2.setTitle("El coronel no tiene quien le escriba");
		tmp2.setId(""+index++);
		libros.put(tmp2.getId(), tmp2);
	}
	
	@Override
	public List<Libro> encontrarLibros() {
		// TODO Auto-generated method stub
		return new ArrayList<Libro>(libros.values());
	}

	@Override
	public void guardarLibros(List<Libro> libros) {
		for (Libro libro : libros) {
			String title = libro.getTitle();
			String author = libro.getAuthor();
			String id = libro.getId();
			boolean exist = id != null;
			if (!exist) {
				id = getId();
				libro.setId(id);
			}
			if ((title != null && !title.equals("")) || (author != null && !author.equals(""))) {
				this.libros.put(libro.getId(), libro);

			}else {
				if(exist) {
					this.libros.remove(id);
				}else {
					index--;
				}
			}
		}

	}

	@Override
	public String getId() {

		return "" + index++;
	}

	@Override
	public List<Libro> encontrarLibros(String auth) {
		Iterator<String> keys = libros.keySet().iterator();
		List<Libro> books = new ArrayList<Libro>();
		while (keys.hasNext()) {
			String tmp = keys.next();
			if (libros.get(tmp).getAuthor().equals(auth)) {
				books.add(libros.get(tmp));
			}
		}
		return books;
	}

}
