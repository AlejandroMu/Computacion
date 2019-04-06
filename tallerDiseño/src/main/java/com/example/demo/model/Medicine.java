package com.example.demo.model;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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
	@OneToMany
	private List<MedicineInventory> inventories;
	
	
}
