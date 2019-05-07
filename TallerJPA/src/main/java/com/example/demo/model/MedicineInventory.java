package com.example.demo.model;

import java.util.*;

import javax.persistence.*;



@Entity
@Table(name="TMedicineInventory")
@NamedQuery(name="inventory.findAll",query="SELECT t FROM TMedicineInventory t;")
public class MedicineInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int amountAvailable;
	private String location;
	private Date dateExpiration;
	
	@ManyToOne
	@JoinColumn(name="medicine", insertable = false, updatable = false)
	private Medicine medicine;
	
	@Override
	public String toString() {
		return "Cantidad :"+amountAvailable + "\n ubicacion " + location;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the amountAvailable
	 */
	public int getAmountAvailable() {
		return amountAvailable;
	}

	/**
	 * @param amountAvailable the amountAvailable to set
	 */
	public void setAmountAvailable(int amountAvailable) {
		this.amountAvailable = amountAvailable;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the dateExpiration
	 */
	public Date getDateExpiration() {
		return dateExpiration;
	}

	/**
	 * @param dateExpiration the dateExpiration to set
	 */
	public void setDateExpiration(Date dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	/**
	 * @return the medicine
	 */
	public Medicine getMedicine() {
		return medicine;
	}

	/**
	 * @param medicine the medicine to set
	 */
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

}
