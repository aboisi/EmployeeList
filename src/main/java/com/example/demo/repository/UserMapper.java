package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.domain.user.model.MUser;

@Mapper
public interface UserMapper {
	
	/** ユーザー総件数取得 */
	public int getUserCount();
	
	/** ユーザー登録 */
	public int insertUser(MUser user);
	
	/** ユーザー取得 */
	public MUser selectUserByUserId(String userId);

}
