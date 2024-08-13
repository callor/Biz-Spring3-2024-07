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

### thymeleaf 기본 사용법
- 서버에서 전달된 변수를 표현하는 방법이 HTML 코드의 tag 속성으로 설정한다
```jsp
<td>${name}</td>
```
```html
<td th:text="#name">홍길동</td>
```
- 속성을 `th:` prefix 로 시작한다.
- 정적 web server를 사용하여 html 파일을 열면 `th:*` 로 설정된 속성은 모두 무시되고 화면에 나타나지 않는다.
- 개발자와 화면디자이너간에 협업관계가 매우 좋아진다.