package com.example.demo.domain.user.service;

import com.example.demo.domain.user.model.MUser;

public interface UserService {
	
	/** 社員IDを生成 */
	public String generateUserId();
	
	/** ユーザー登録 */
	public void signup(MUser user);
}

