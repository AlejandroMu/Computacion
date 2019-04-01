package com.example.demo.model;

public class Singleton {
	private Person person;
	public Person getPerson() {
		return person ==null?person=new Person():person;
	}

}
