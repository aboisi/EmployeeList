package com.example.demo.domain.user.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.user.model.MUser;
import com.example.demo.domain.user.service.UserService;
import com.example.demo.repository.UserMapper;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper mapper;
	
	/** 社員ID生成 */
	@Override
	public String generateUserId() {
		//レコードの総数を取得
		int count = mapper.getUserCount();//getUserCountはUserMapper.xmlと対応
		
		//マシン日付(年)を取得
		LocalDate now = LocalDate.now();
		int year = now.getYear();
		
		//社員ID生成
		String userId = String.format("%d%3d",year, count + 1);
		
		//呼び出し元に返す
		return userId;
	}

	/** ユーザー登録 */
	@Override
	public void signup(MUser user) {
		//先に社員IDを採番
		String newId = generateUserId();
		user.setUserId(newId); //setUserIdはMUser.javaで設定
		
		//DBへ登録
		mapper.insertUser(user);
		
	}
}