package com.example.demo.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SignupForm {
	private String name;
	private LocalDate birthday;
	private String password;
	private String gender;
	
}