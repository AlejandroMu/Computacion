package co.edu.icesi.ci.thymeval.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@NonNull
	private String username;
	
	@NotBlank
	@NonNull
	private String password;
	
	private String name;
	
	@Email(message = "El correo debe ser válido")
	private String email;
	
	private UserType type;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past
	private LocalDate birthDate;
	
	private UserGender gender;
	
	@OneToMany
	private List<Appointment> appointments;
}
