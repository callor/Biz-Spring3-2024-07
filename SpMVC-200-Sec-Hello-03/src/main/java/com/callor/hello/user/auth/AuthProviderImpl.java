package com.callor.hello.user.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.callor.hello.dao.RoleDao;
import com.callor.hello.dao.UserDao;
import com.callor.hello.model.RoleVO;
import com.callor.hello.model.UserVO;

/*
 * Spring Security 에서 로그인 처리를 하기 위한
 * Custom Class
 * DB 로 부터 사용자 정보를 조회하고, 하는 등등을 처리해야 한다.
 */
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider {

	private final UserDao userDao;
	private final RoleDao roleDao;
	private final PasswordEncoder passEncoder;
	public AuthProviderImpl(UserDao userDao,RoleDao roleDao, PasswordEncoder passEncoder) {
		super();
		this.userDao = userDao;
		this.passEncoder = passEncoder;
		this.roleDao = roleDao;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		// login.jsp 에서 form 담겨 전달된 username(u_name)과 password(u_pass)의 값이
		// authentication 에 담겨서 전달된다.
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		

		UserVO userVO = userDao.findById(username);
		if(userVO == null) {
			throw new UsernameNotFoundException("USERNAME 을 확인하세요");
		}
		
		// 사용자가 입력한 비번(password)과
		// DB 에 저장된 암호화된 비번(userVO.getPassword()) 를 비교해달라
		// 일치하면 true 아니면 false
		boolean yesPassword = passEncoder.matches(password, userVO.getPassword());
		if(!yesPassword) {
			throw new BadCredentialsException("비밀번호가 틀렸습니다");
		}
		List<RoleVO> roleList = roleDao.findByUsername(username);
		
		// 로그인한 사용자의 권한 리스트 만들기
		List<GrantedAuthority> grantList = new ArrayList<>();
		for(RoleVO role : roleList) {
			grantList.add(new SimpleGrantedAuthority(role.getR_role()));
		}

		// 생성한 사용자정보와 권한리스트를 사용하여 토큰 만들기
		UsernamePasswordAuthenticationToken
		toKen = new UsernamePasswordAuthenticationToken(userVO,password, grantList);
		return toKen;
	
	}

	/*
	 * Auth...Provider 를 상속받아 클래스를 작성하는 경우
	 * supports() method 의 return 을 반드시 true 로 만들어줘여 한다
	 */
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return true;
	}

}
