package com.example.demo.domain.user.model;

import java.sql.Timestamp;
import java.util.Date;

import lombok.Data;

@Data
public class MUser {
	//private String id; 今回はidを自分で設定のため
	private String userId;
	private String name;
	private String password;
	private Date birthday;
	private String gender;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Timestamp deleteDate;
}