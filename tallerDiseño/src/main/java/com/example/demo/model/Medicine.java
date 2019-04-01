package com.example.demo.model;

import java.util.*;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Medicine {
	
	private int id;
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
	private List<MedicineInventory> inventories;
	
	
}
