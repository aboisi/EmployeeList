package com.example.demo.domain.user.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MUser {
	//private String id; 今回はidを自分で設定のため
	private String userId;
	private String name;
	private String password;
	private LocalDate birthday;
	private String gender;
	private LocalDate createDate;
	private LocalDate updateDate;
	private LocalDate deleteDate;
}