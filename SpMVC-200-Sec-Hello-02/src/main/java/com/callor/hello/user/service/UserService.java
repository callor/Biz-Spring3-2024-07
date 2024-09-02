package com.callor.hello.user.service;

import com.callor.hello.model.UserVO;

public interface UserService {

	public UserVO createUser(UserVO userVO);
	public UserVO findByUser(String username);

}
