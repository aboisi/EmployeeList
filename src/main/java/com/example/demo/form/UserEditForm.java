package com.example.demo.form;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserEditForm {
	private String userId;
	private String name;
	private String password;
	private LocalDate birthday;
	private Integer gender;
}