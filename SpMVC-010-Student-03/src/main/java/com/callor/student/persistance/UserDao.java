package com.callor.student.persistance;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.callor.student.models.UserVO;

public interface UserDao {

	@Select("SELECT * FROM tbl_users")
	public List<UserVO> selectAll();
	
	@Select("SELECT * FROM tbl_users WHERE username = #{username}")
	public UserVO findByUserName(String username);
	
	public int insert(UserVO userVO);
	
}
