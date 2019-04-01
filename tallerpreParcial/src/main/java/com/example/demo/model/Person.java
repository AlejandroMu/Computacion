package com.example.demo.model;

import lombok.*;
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Person {

	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
}
