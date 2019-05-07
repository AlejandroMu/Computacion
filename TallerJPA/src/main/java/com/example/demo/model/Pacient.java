package com.example.demo.model;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "TPacient")
@NamedQuery(name = "pacient.findAll", query = "SELECT t FROM TPacient t;")
public class Pacient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String document;
	private String name;
	private String lastName;
	private String academicProgram;
	private boolean state;

	@OneToMany(mappedBy = "TPacient")
	private List<UrgencyAtention> atentions;

	@OneToMany(mappedBy = "TPacient")
	private List<Supply> supplys;

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
	public List<UrgencyAtention> getAtentions() {
		return atentions;
	}

	/**
	 * @param atentions the atentions to set
	 */
	public void setAtentions(List<UrgencyAtention> atentions) {
		this.atentions = atentions;
	}

	/**
	 * @return the supplys
	 */
	public List<Supply> getSupplys() {
		return supplys;
	}

	/**
	 * @param supplys the supplys to set
	 */
	public void setSupplys(List<Supply> supplys) {
		this.supplys = supplys;
	}

	public Supply addSupply(Supply n) {
		getSupplys().add(n);
		n.setPacient(this);
		return n;
	}

	public Supply removeSupply(Supply n) {
		getSupplys().remove(n);
		n.setPacient(null);
		return n;
	}
}
