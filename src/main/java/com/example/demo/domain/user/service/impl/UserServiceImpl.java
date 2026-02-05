package com.example.demo.domain.user.service.impl;

import java.time.LocalDate;
import java.util.List;

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
		String userId = String.format("%d%03d",year, count + 1);
		
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
	
	/** ユーザー取得 */
	@Override
	public MUser findByUserId(String userId) {
		return mapper.selectUserByUserId(userId);
	}
	
	/** 社員一覧取得 */
	@Override
	public List<MUser> getUserList() {
		return mapper.selectUserList();
	}
	
	/** ユーザー更新(1件) */
	@Override
	public void updateUserOne(String userId,
			String name,
			String password,
			String birthday,
			String gender) {
		mapper.updateOne(userId, name, password, birthday, gender);
	}
	
	/** ユーザー削除(1件) */
	@Override
	public void deleteUserOne(String userId) {
		int count = mapper.deleteOne(userId);
		if (count == 0) {
			throw new RuntimeException("削除対象のユーザーが存在しません");
			
		}
	}
}