# Spring MVC Project
- 학생관리 시스템 2024

## DBMS 와 연동된 Spring MVC Project
- MySQL, MyBatis 를 연동하여 학생관리 CRUD 를 구현하는 프로젝트
- MySQL, MyBatis 를 연동하여 프로젝트를 구현하기 위하여 `maven dependencies`를 설정해야 한다.
- 필요한 dependencies 는 `spring-jdbc`, `mybatis`, `mybatis-spring`, `commns-dbcp2`, `mysql-connector` 가 필요하다

- 다음의 dependencies 를 `maven repository` 에서 검색하여 `pom.xml` 등록한다.
```xml
<!-- 
	spring jdbc 로 검색 
	spring webmvc 와 버전 일치시킬
-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.25.RELEASE</version>
</dependency>

<!-- mybatis 로 검색하여 mybatis, mybatis-spring 찾기 -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.16</version>
</dependency>
<!-- 
	spring-webmvc 5.2.x.RELEASE 를 사용할때는
	mybatis-spring 을 반드시 3.0.0 이하 버전을 사용할 것
-->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>3.0.0</version>
</dependency>

<!-- dbcp 로 검색하여 commons-dbcp2 를 사용할 것 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-dbcp2</artifactId>
    <version>2.12.0</version>
</dependency>

<!-- 
	mysql 로 검색하고
	반드시 mysql-connector-j 를 사용할 것
	mysql-connector-java 는 한글 문제와 timeZone 설정부분에서
	문제를 일으킬수 있다
 -->
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>
```

## DBMS 연동을 위한 `context.xml` 파일 작성하기
- `Spring Project`의 `/WEB-INF/spring/appServlet` 폴더에 `spring bean confiruration file`을 생성한다.
- 이때 파일은 `*-context.xml` 형식의 패턴으로 이름을 정한다.
- `*-context.xml` 형식의 패턴으로 이름을 정하면 `web.xml`에서 파일을 자동으로 인식하고 프로젝트가 실행될때 설정값을 읽어서 프로젝트를 초기화 한다
- 여기에서는 `db-context.xml` 라는 이름으로 설정할 것이다.
```xml
<!-- db-context.xml 에는 다음의 3가지 bean 과 기타 설정이 추가된다 -->
<!-- dataSource bean-->
<!-- SqlSessionFactoryBean -->
<!-- SqlSessionTemplate bean-->

<!-- mybatis component scan -->
```