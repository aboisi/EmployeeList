package com.example.demo.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

//springBootバーションが3以降はjakarta
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank(message = "{signup.name.required}")
	private String name;
	
	@NotNull(message = "{signup.birthday.required}")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthday;
	
	@NotBlank(message = "{signup.password.required}")
	private String password;
	
	@NotBlank(message = "{signup.gender.required}")
	private String gender;
	
}