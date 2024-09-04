package com.callor.hello.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.model.RoleVO;
import com.callor.hello.model.UserVO;
import com.callor.hello.user.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

	private final PasswordEncoder passEncoder;
	private final UserDao userDao;
	private final RoleDao roleDao;
	public UserServiceImpl(PasswordEncoder passEncoder, UserDao userDao, RoleDao roleDao) {
		super();
		this.passEncoder = passEncoder;
		this.userDao = userDao;
		this.roleDao = roleDao;
	}

	@Autowired
	public void create_table() {
		
		try {
			userDao.create_user_table(null);
			roleDao.create_role_table(null);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	/*
	 * 회원가입 신청된 사용자 정보를 tbl_users, tbl_role 테이블에 INSERT 하기
	 * 1. tbl_users 에 데이터가 있는지 확인
	 * 2. 없으면 이 사용자는 "ROLE_ADMIN" 권한을 부여한다
	 * 3. 또한 "ROLE_USER" 권한도 같이 부여한다
	 * 
	 * 4. 만약 tbl_users 테이블에 데이터가 있으면
	 * 5. 이 사용자는 ROLE_USER 권한만 갖는다
 	 */
	@Override
	@Transactional
	public UserVO createUser(UserVO userVO) throws DataAccessException {
		// TODO Auto-generated method stub
		log.debug("User {}",userVO.toString());
		
		List<UserVO> userList = userDao.selectAll();
		
		String encPassword = passEncoder.encode(userVO.getPassword());
		userVO.setPassword(encPassword);

		List<RoleVO> roles = new ArrayList<>();
		if(userList.size() > 0) {
			// 이미 회원 가입된 데이터가 있다
			roles.add(RoleVO.builder()
					.r_username(userVO.getUsername())
					.r_role("ROLE_USER")
					.build());
		} else {
			// 회원가입 된 데이터가 없다
			roles.add(RoleVO.builder()
				.r_username(userVO.getUsername())
				.r_role("ROLE_ADMIN")
				.build());
			roles.add(RoleVO.builder()
					.r_username(userVO.getUsername())
					.r_role("ROLE_USER")
					.build());
			
		}
		
		int ret = userDao.insert(userVO);
		ret += roleDao.insert(roles);
		
		return userVO;
	}

	@Override
	public UserVO findByUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
