package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UrgencyAtention {
	private int id;
	@NonNull
	private Date dateHour;
	@NonNull
	private Pacient pacient;
	@NonNull
	private String generalDescription;
	@NonNull
	private String procedureDone;
	private boolean transfer;
	@NonNull
	private String placeTransfer;
	@NonNull
	private String observations;
	@NonNull
	private List<Supply> supplys;
}
