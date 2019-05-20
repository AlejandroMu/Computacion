package com.taller.tallerjpa.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TMedicine")
@NamedQuery(name = "medicine.findAll", query = "SELECT t FROM Medicine t")
public class Medicine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	private String genericName;

	private String laboratory;
	private String administationType;
	private String indications;
	private String contraIndications;

	@OneToMany(mappedBy = "medicine")
	private List<Supply> supplys;	

	@OneToMany(mappedBy = "medicine")
	private List<MedicineInventory> inventories;
	
	public Medicine(){
		this.supplys=new ArrayList<Supply>();
		this.inventories=new ArrayList<MedicineInventory>();
	}
	public Medicine(String name,String genericName,String laboratory,String administationType,String indications,String contraIndications){
		this.name=name;
		this.genericName=genericName;
		this.laboratory=laboratory;
		this.administationType=administationType;
		this.indications=indications;
		this.contraIndications=contraIndications;
		this.supplys=new ArrayList<Supply>();
		this.inventories=new ArrayList<MedicineInventory>();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the genericName
	 */
	public String getGenericName() {
		return genericName;
	}

	/**
	 * @param genericName the genericName to set
	 */
	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	/**
	 * @return the laboratory
	 */
	public String getLaboratory() {
		return laboratory;
	}

	/**
	 * @param laboratory the laboratory to set
	 */
	public void setLaboratory(String laboratory) {
		this.laboratory = laboratory;
	}

	/**
	 * @return the administationType
	 */
	public String getAdministationType() {
		return administationType;
	}

	/**
	 * @param administationType the administationType to set
	 */
	public void setAdministationType(String administationType) {
		this.administationType = administationType;
	}

	/**
	 * @return the indications
	 */
	public String getIndications() {
		return indications;
	}

	/**
	 * @param indications the indications to set
	 */
	public void setIndications(String indications) {
		this.indications = indications;
	}

	/**
	 * @return the contraIndications
	 */
	public String getContraIndications() {
		return contraIndications;
	}

	/**
	 * @param contraIndications the contraIndications to set
	 */
	public void setContraIndications(String contraIndications) {
		this.contraIndications = contraIndications;
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

	/**
	 * @return the inventories
	 */
	public List<MedicineInventory> getInventories() {
		return inventories;
	}

	/**
	 * @param inventories the inventories to set
	 */
	public void setInventories(List<MedicineInventory> inventories) {
		this.inventories = inventories;
	}

	public MedicineInventory addMedicineInventory(MedicineInventory m) {
		getInventories().add(m);
		m.setMedicine(this);
		return m;
	}

	public MedicineInventory removeMedicineInventory(MedicineInventory m) {
		getInventories().remove(m);
		m.setMedicine(null);
		return m;
	}

	public Supply addSupply(Supply m) {
		getSupplys().add(m);
		m.setMedicine(this);
		return m;
	}

	public Supply removeSupply(Supply m) {
		getSupplys().remove(m);
		m.setMedicine(null);
		return m;
	}

}
