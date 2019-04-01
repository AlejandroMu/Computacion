package com.example.demo.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {
	@NonNull
	private String login;
	@NonNull
	private String name;
	@NonNull
	private String lastName;
	@NonNull
	private char[] password;

	private boolean state;
	@NonNull
	private Pacient pacient;
}
