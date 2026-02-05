package com.example.demo.domain.user.service;

import java.util.List;

import com.example.demo.domain.user.model.MUser;

public interface UserService {
	
	/** 社員IDを生成 */
	public String generateUserId();
	
	/** ユーザー登録 */
	public void signup(MUser user);
	
	/** ユーザー取得(社員ID指定) */
	public MUser findByUserId(String userId);
	
	/** 社員一覧取得 */
	List<MUser> getUserList();
	
	/** ユーザー更新(i件) */
	public void updateUserOne(String userId,
			String name,
			String password,
			String birthday,
			String gender);
	
	/** ユーザー削除(1件) */
	public void deleteUserOne(String userId);
}

