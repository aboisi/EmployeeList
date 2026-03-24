package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.user.model.MUser;

@Mapper
public interface UserMapper {
	
	/** ユーザー総件数取得 */
	public int getUserCount();
	
	/** ユーザー登録 */
	public int insertUser(MUser user);
	
	/** ユーザー取得(1件) */
	public MUser selectUserByUserId(String userId);
	
	/** 社員一覧取得 */
	public List<MUser> selectUserList(MUser user);
	
	/** ユーザー更新(1件) */
	public int updateOne(@Param("userId") String userId,
		@Param("name") String name,
		@Param("password") String password,
		@Param("birthday") LocalDate birthday,
		@Param("gender") Integer gender);
	
	/** ユーザー削除(1件) */
	public int deleteOne(@Param("userId") String userId);

}
