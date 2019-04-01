package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Pacient {
	@NonNull
	private String document;
	@NonNull
	private String names;
	@NonNull
	private String lastNames;
	@NonNull
	private String academicProgram;
	
	private boolean state;
	
	private List<UrgencyAtention> atentions;
	private List<Supply> supplys;
	private User user;
}
