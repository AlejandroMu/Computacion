package com.example.demo.model;

import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class MedicineInventory {
	
	private Medicine medicine;
	
	private int amountAvailable;
	@NonNull
	private String location;
	@NonNull
	private Date dateExpiration;
	
}
