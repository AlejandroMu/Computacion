package com.taller.tallerjpa.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "TPacient")
@NamedQuery(name = "pacient.findAll", query = "SELECT t FROM Pacient t")
public class Pacient implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	private String document;
	private String name;
	private String lastName;
	private String academicProgram;
	private boolean state;

	@OneToMany(mappedBy = "pacient")
	private List<Atencion> atentions;
	
	@OneToMany(mappedBy = "pacient")
	private List<Supply> supplies;

	public Pacient(){
		atentions=new ArrayList<Atencion>();
		supplies=new ArrayList<Supply>();
	}
	public Pacient(String document,String name,String lastName,String academicProgram,boolean state){
		this.document=document;
		this.name=name;
		this.lastName=lastName;
		this.academicProgram=academicProgram;
		this.state=state;
		atentions=new ArrayList<Atencion>();
		supplies=new ArrayList<Supply>();
	}

	public String toString() {
		return document + " " + name + " " + lastName;
	}

	/**
	 * @return the document
	 */
	public String getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(String document) {
		this.document = document;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the academicProgram
	 */
	public String getAcademicProgram() {
		return academicProgram;
	}

	/**
	 * @param academicProgram the academicProgram to set
	 */
	public void setAcademicProgram(String academicProgram) {
		this.academicProgram = academicProgram;
	}

	/**
	 * @return the state
	 */
	public boolean isState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(boolean state) {
		this.state = state;
	}

	/**
	 * @return the atentions
	 */
	public List<Atencion> getAtentions() {
		return atentions;
	}

	/**
	 * @param atentions the atentions to set
	 */
	public void setAtentions(List<Atencion> atentions) {
		this.atentions = atentions;
	}

	public Atencion addAtention(Atencion n) {
		getAtentions().add(n);
		List<Supply> s=n.getSupplys();
		s.forEach(x->addSupply(x));
		n.setPacient(this);
		return n;
	}

	public Atencion removeAtention(Atencion n) {
		getAtentions().remove(n);
		List<Supply> sup=n.getSupplys();
		n.setPacient(null);
		return n;
	}

	/**
	 * @return the supplies
	 */
	public List<Supply> getSupplies() {
		return supplies;
	}

	/**
	 * @param supplies the supplies to set
	 */
	public void setSupplies(List<Supply> supplies) {
		this.supplies = supplies;
	}

	public void addSupply(Supply supply){
		getSupplies().add(supply);
		supply.setPacient(this);
	}
	public void removeSupply(Supply supply){
		getSupplies().remove(supply);
		supply.setPacient(null);
	}
}
