package com.callor.student.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.callor.student.models.UserVO;
import com.callor.student.persistance.UserDao;
import com.callor.student.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	protected final UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	/*
	 * 회원가입 서비스
	 * 1. 애플리케이션을 불특정 다수가 아닌 일정한 그룹에서 사용하는 경우
	 *   보통 회원정보 Table 을 1개로 통합 관리한다
	 *   정해진것은 없지만, 사용자가 소수(1천명이하)인 경우가 해당
	 *   
	 * 2. 그룹에서 사용하는 애플리케이션을 설치하고, 
	 * 	최초로 사용자 등록(회원가입)을 하는 경우, 
	 * 	최초로 가입하는 사용자에게 admin(관리자) 권한을 부여하고
	 *  그 이후 가입하는 사용자는 일반 사용자로 분류한다.
	 *  
	 * 3. 회원가입 요청이 Controller 로 부터 전달되면
	 * 	 DB Table 에서 사용자 목록을 조회하고
	 *   DB 에 등록된 사용자가 한명도 없을 경우 요청한 사용의 권한을
	 *   admin 으로 설정한다
	 *   
	 *   DB Table 에 사용자가 한명이라도 등록되어 있다면
	 *   이 사용자는 일반 user 로 설정한다
	 */
	
	@Override
	public int join(UserVO userVO) {

		List<UserVO> users = userDao.selectAll();
		if(users == null || users.size() < 1) {
			userVO.setRole("ADMIN");
		} else {
			userVO.setRole("USER");
		}
		int ret = userDao.insert(userVO);
		return ret;
	}

	@Override
	public UserVO findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
