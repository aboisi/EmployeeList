package com.example.demo.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

//springBootバーションが3以降はjakarta
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank
	private String name;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate birthday;
	
	@NotBlank
	private String password;
	
	@NotNull
	private String gender;
	
}