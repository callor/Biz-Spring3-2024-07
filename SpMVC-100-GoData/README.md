# 공공데이터활용
- 광주광역시 BIS 시스템을 활용한 버스도착정보 프로젝트

## thymeleaf layout
- JSP를 데체하는 새로운 방식의 Spring Template Engine
- Spring boot 에서는 JSP 를 전혀사용하지 않고, thymeleaf 와 같은 도구를 사용한다. SpringMVC 에서는 JSP를 기본으로 사용하는데, 여기에서 thymeleaf 를 사용하여 화면을 구현하고자 한다.
```xml
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf</artifactId>
	<version>${org.thymeleaf-version}</version>
</dependency>
<dependency>
	<groupId>org.thymeleaf</groupId>
	<artifactId>thymeleaf-spring5</artifactId>
	<version>${org.thymeleaf-version}</version>
</dependency>
<dependency>
	<groupId>nz.net.ultraq.thymeleaf</groupId>
	<artifactId>thymeleaf-layout-dialect</artifactId>
	<version>3.3.0</version>
</dependency>
```