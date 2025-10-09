package com.example.demo.domain.user.model;

import java.util.Date;

import lombok.Data;

@Data
public class MUser {
	private String id;
	private String name;
	private String password;
	private Date birthday;
	private String gender;
	private Date createDate;
	private Date updateDate;
	private Date deleteDate;
}