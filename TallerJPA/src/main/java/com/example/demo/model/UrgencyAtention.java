package com.example.demo.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="TAtencion")
@NamedQuery(name="atencion.findAll",query="SELECT t FROM TAtencion t;")
public class UrgencyAtention {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private Date dateHour;
	
	private String generalDescription;
	private String procedureDone;
	private boolean transfer;
	
	private String placeTransfer;
	private String observations;
	
	@OneToMany(mappedBy="TAtencion")
	private List<Supply> supplys;
	
	@ManyToOne
	@JoinColumn(name="pacient", insertable = false, updatable = false)
	private Pacient pacient;
	
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
	 * @return the generalDescription
	 */
	public String getGeneralDescription() {
		return generalDescription;
	}
	
	/**
	 * @param generalDescription the generalDescription to set
	 */
	public void setGeneralDescription(String generalDescription) {
		this.generalDescription = generalDescription;
	}

	/**
	 * @return the procedureDone
	 */
	public String getProcedureDone() {
		return procedureDone;
	}

	/**
	 * @param procedureDone the procedureDone to set
	 */
	public void setProcedureDone(String procedureDone) {
		this.procedureDone = procedureDone;
	}

	/**
	 * @return the transfer
	 */
	public boolean isTransfer() {
		return transfer;
	}

	/**
	 * @param transfer the transfer to set
	 */
	public void setTransfer(boolean transfer) {
		this.transfer = transfer;
	}

	/**
	 * @return the placeTransfer
	 */
	public String getPlaceTransfer() {
		return placeTransfer;
	}
	
	/**
	 * @param placeTransfer the placeTransfer to set
	 */
	public void setPlaceTransfer(String placeTransfer) {
		this.placeTransfer = placeTransfer;
	}
	
	/**
	 * @return the observations
	 */
	public String getObservations() {
		return observations;
	}
	
	/**
	 * @param observations the observations to set
	 */
	public void setObservations(String observations) {
		this.observations = observations;
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
	
	public Supply addSupply(Supply n){
		getSupplys().add(n);
		n.setAtencion(this);
		return n;
	}
	
	public Supply removeSupply(Supply n){
		getSupplys().remove(n);
		n.setAtencion(null);
		return n;
	}
}
