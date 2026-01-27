package com.example.demo.domain.user.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MUser {
	//private String id; 今回はidを自分で設定のため
	private String userId;
	private String name;
	private String password;
	private LocalDate birthday;
	private Integer gender;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;
	private LocalDateTime deleteDate;
}