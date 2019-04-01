package com.example.demo.model;

import org.springframework.stereotype.Component;


public class Prototype {
	private Person person;
	public Person getPerson() {
		return person ==null?person=new Person():person;
	}
	
}
