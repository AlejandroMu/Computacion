package com.example.demo.model;

import org.springframework.stereotype.Component;

import lombok.*;
@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Component
public class Objeto1 {
	@NonNull
	private String nombre;
	@NonNull
	private String codigo;
	private int numerox;
}
