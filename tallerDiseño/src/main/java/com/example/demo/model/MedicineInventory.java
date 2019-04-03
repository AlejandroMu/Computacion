package com.example.demo.model;

import java.util.*;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MedicineInventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne
	private Medicine medicine;
	
	private int amountAvailable;
	@NonNull
	private String location;
	@NonNull
	private Date dateExpiration;
	
}
