# tiles 를 이용한 JSP Layout 만들기
- 단순 JSP 로 여러 페이지를 만들때, 중복되는 코드가 많이 발생한다
- 코드 중복을 줄이기 위해 `<%@ include %>` 를 사용하여 다른 페이지를 `include`하는 방식으로 많이 사용한다.
- `include` 방식은 내부적으로 `include` 된 페이지가 모두 뭉처서 한개의 페이지로 rendering 되고 client 으로 전달된다. 때로는 이러한 방식은 네트워크를 통하여 불필요한 자료 다운로드 되는 현상이 발생한다.
- `tiles` 도구를 사용하면 비교적 가벼운 layout 을 만들고, 효율적으로 페이지를 관리할 수 있다. `spring MVC`와 `JSP`를 사용하는 `Web Application`에서는 과거에 아주 많이 사용하던 도구이다.

## tiles 를 사용하기 위한 dependencies
- tiles 도구를 사용하는데 많은 코드 예제를 찾을 수 있다. 하지만 많은 예제들이 불필요한 depdencies 를 설정하는 방법을 제시하고 있다.
- Spring MVC 프로젝트에서 tiles 를 사용하기 위해서는 다음 2개의 dependencies 만 설정해 주면, 나머지 필요한 dependecies 는 자동으로 설정된다.
- 또한 2개의 depcendecies 는 반드시 버전을 동일한 것으로 설정해야 한다
```xml
<properties>
	<org.apache.tiles-version>3.0.8</org.apache.tiles-version>
<properties>
<dependency>
	<groupId>org.apache.tiles</groupId>
	<artifactId>tiles-core</artifactId>
	<version>${org.apache.tiles-version}</version>
</dependency>

<dependency>
	<groupId>org.apache.tiles</groupId>
	<artifactId>tiles-extras</artifactId>
	<version>${org.apache.tiles-version}</version>
</dependency>
```