# Spring Security Project
- `Java` 기반의 `WAS(Web Application Service)`프로젝트에서 회원가입, 로그인 등을 관리하기 위하여 보통 `HttpSession` 도구를 사용하여 로그인한 사용자의 정보를 `Session` 에 보관하고, 보관된 `Session` 정보를 참조하여 정상적인 사용자 인지 확인하는 절차를 수행한다.
- `HttpSession`을 이용한 회원인증절차
	1. 로그인 화면을 보여준다
	2. username, password 를 입력한후 로그인 실행
	3. `Controller`에서 username, password 를 검사하여 정상적인 사용자 이면 이 정보를 `HttpSession` 을 사용하여 서버변수에 저장
	4. 사용자가 다른 Page(Router, 요청)에 접근을 시도하면, Browser 에 저장된 `SessionID`를 함께 서버로 전송
	5. 사용자가 접근하는 Controller.method() 에서 `HttpSession`을 사용하여 서버 메모리에 보관중인 사용자 정보가 있는지 확인
	6. 사용자 정보가 있으면 서비스를 실행
	7. 사용자 정보가 만료되거나 없는 경우 서비스 거부

- `HttpSession` 을 사용하는 것은 프로젝트가 작을 때는 매우 쉽게 구현이 가능하다.
- 하지만 사용자 인증을 수행해야 할 `URL`, `Router` 가 많아지면 일일이 사용자 인증을 수행하는 코드를  모든 `Controller.method` 에 중복하여 작성해야 한다.
- 중복코드가 많아지면 유지보수가 어려워지고, 프로젝트가 커질수록 오류 또는 보안 이슈가 발생할 수 있다.
- `Spring Security`는 사용자의 인증 절차를 한곳으로 모아서 통합하여 관리하고, 여기에 인가절차를 추가하여 보안문제를 해결해 나간다.

## 보안과 관련된 용어
- 인증 : username과 password 를 사용하여 로그인을 수행하고, 정상적인 사용자 인지 확인하는 절차
- 인가 : 정상적으로 인증된 사용자에게 권한을 부여하는 것, 권한은 사용자에 따라 제한적으로 부여한다.
- 권한 : 역할, ROLE 이라고 하여 각 Router 별로 세밀하게 관리하는 것이 좋다

## Spring Security 를 사용하기 위한 dependecies
```xml
<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-web -->
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-web</artifactId>
	<version>${org.springframework.security-version}</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-config -->
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-config</artifactId>
	<version>${org.springframework.security-version}</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.springframework.security/spring-security-taglibs -->
<dependency>
	<groupId>org.springframework.security</groupId>
	<artifactId>spring-security-taglibs</artifactId>
	<version>${org.springframework.security-version}</version>
</dependency>
```

## 회원가입, DB 연동하는 로그인
```
spring-jdbc
mybatis
mybatis-spring
commons-dbcp2
mysql
```
```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>${org.springframework-version}</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.16</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>3.0.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-dbcp2 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.12.0</version>
</dependency>
<!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>
```
