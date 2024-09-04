package com.callor.hello.user.service;

import org.springframework.dao.DataAccessException;

import com.callor.hello.model.UserVO;

public interface UserService {

	public UserVO createUser(UserVO userVO) throws DataAccessException;
	public UserVO findByUser(String username);

}
