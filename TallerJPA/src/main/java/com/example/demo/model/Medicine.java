package com.example.demo.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="t_Medicine")
@NamedQuery(name="medicine.findAll",query="SELECT t FROM t_Medicine t;")
public class Medicine {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String genericName;
	@NonNull
	private String laboratory;
	@NonNull
	private String administationType;
	@NonNull
	private String indications;
	@NonNull
	private String contraIndications;
	
	
	
}
