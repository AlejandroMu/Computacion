package com.taller.tallerjpa.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;



@Entity
@Table(name="TMedicineInventory")
@NamedQuery(name="inventory.findAll",query="SELECT t FROM MedicineInventory t")
public class MedicineInventory implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long amountAvailable;
	private String location;
	private Date dateExpiration;
	
	@ManyToOne
	@JoinColumn(name="medicine_id")
	private Medicine medicine;

	public MedicineInventory(long amount,String location,Date date){
		
		this.amountAvailable=amount;
		this.location=location;
		this.dateExpiration=date;
	}
	
	@Override
	public String toString() {
		return "Cantidad :"+amountAvailable + "\n ubicacion " + location;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the amountAvailable
	 */
	public long getAmountAvailable() {
		return amountAvailable;
	}

	/**
	 * @param amountAvailable the amountAvailable to set
	 */
	public void setAmountAvailable(long amountAvailable) {
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
