package com.callor.hello.user.auth;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.callor.hello.user.models.UserVO;

/*
 * Spring Security 에서 로그인 처리를 하기 위한
 * Custom Class
 * DB 로 부터 사용자 정보를 조회하고, 하는 등등을 처리해야 한다.
 */
@Service("authProviderImpl")
public class AuthProviderImpl implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		// login.jsp 에서 form 담겨 전달된 username(u_name)과 password(u_pass)의 값이
		// authentication 에 담겨서 전달된다.
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		
		if(username == null || username.isBlank() || !username.equals("callor")) {
			/*
			 * 사용자 정보오류(없음..)를 Spring Security 에게 전달하기 위하여
			 * return 명령을 실행하는 대신 exception 을 발생시켜
			 * 메시지를 부모에게 전달한다
			 */
			throw new UsernameNotFoundException("USERNAME 확인필요");
		}
		if(password == null || password.isBlank() || !password.equals("12345")) {
			throw new BadCredentialsException("비밀번호 확인 필요");
		}
		
		// 로그인한 사용자의 정보를 만들기
		UserVO user = UserVO.builder()
					.username(username)
					.email("callor@callor.com")
					.name("홍길동")
					.build();
		
		// 로그인한 사용자의 권한 리스트 만들기
		List<GrantedAuthority> grantList = new ArrayList<>();
		grantList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		grantList.add(new SimpleGrantedAuthority("ROLE_USER"));


		// 생성한 사용자정보와 권한리스트를 사용하여 토큰 만들기
		UsernamePasswordAuthenticationToken
		toKen = new UsernamePasswordAuthenticationToken(user,password, grantList);
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
