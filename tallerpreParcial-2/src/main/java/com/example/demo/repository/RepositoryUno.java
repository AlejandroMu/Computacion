package com.example.demo.repository;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.*;

@Repository
public class RepositoryUno {
	@Autowired
	private Objeto1 objetoUno;
	@Autowired
	private Objeto2 objetoDos;
	
	@PostConstruct
	public void init() {
		System.out.println(objetoUno.getCodigo());
		System.out.println(objetoDos.getCodigo()+"Uis");

	}
}
