package com.example.demo.model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="TSupply")
@NamedQuery(name="supply.findAll",query="SELECT t FROM TSupply t;")
public class Supply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer amount; 
	
	private Date dateHour; 
	private String observation; 
	private String pathology; 
	
	@ManyToOne
	@JoinColumn(name="medicine", insertable = false, updatable = false)
	private Medicine medicine;

	@ManyToOne
	@JoinColumn(name="pacient", insertable = false, updatable = false)
	private Pacient pacient; 

	@ManyToOne
	@JoinColumn(name="atencion", insertable = false, updatable = false)
	private UrgencyAtention atencion;

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

	/**
	 * @return the amount
	 */
	public Integer getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	/**
	 * @return the pacient
	 */
	public Pacient getPacient() {
		return pacient;
	}

	/**
	 * @param pacient the pacient to set
	 */
	public void setPacient(Pacient pacient) {
		this.pacient = pacient;
	}

	/**
	 * @return the dateHour
	 */
	public Date getDateHour() {
		return dateHour;
	}

	/**
	 * @param dateHour the dateHour to set
	 */
	public void setDateHour(Date dateHour) {
		this.dateHour = dateHour;
	}

	/**
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}

	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}

	/**
	 * @return the pathology
	 */
	public String getPathology() {
		return pathology;
	}

	/**
	 * @param pathology the pathology to set
	 */
	public void setPathology(String pathology) {
		this.pathology = pathology;
	}

	/**
	 * @return the atencion
	 */
	public UrgencyAtention getAtencion() {
		return atencion;
	}

	/**
	 * @param atencion the atencion to set
	 */
	public void setAtencion(UrgencyAtention atencion) {
		this.atencion = atencion;
	}
	
}
