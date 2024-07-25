package com.callor.student.service;

import com.callor.student.models.UserVO;

public interface UserService {

	// 회원가입을 실행하기 위한 method
	public int join(UserVO userVO);
	
	// username 의 회원정보를 return method
	public UserVO findByUserName(String username);

}
