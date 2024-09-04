package com.callor.hello.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.hello.model.UserVO;

public interface UserDao {

	@Select("SELECT * FROM tbl_users")
	public List<UserVO> selectAll();
	
	@Select("SELECT * FROm tbl_users WHERE username = #{username}")
	public UserVO findById(String username);
	
	@Select("SELECT * FROM tbl_users WHERE email = #{email} ")
	public List<UserVO> findByEmail(String email);
	public void create_user_table(String dumy);

	public int insert(UserVO userVO);
	
	
}
