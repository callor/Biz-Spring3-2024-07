<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" 
		prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content='width=device-width, initial-scale=1.0' />
<title>Insert title here</title>
<link href="${rootPath}/static/css/main.css" rel="stylesheet"/>
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/nav.js"></script>
</head>
<body>
	<nav class="main">
		<ul>
			<li class="home">Home</li>
			<li class="bbs notice">공지사항</li>
			<li class="bbs free">자유게시판</li>
			
			<sec:authorize access="isAnonymous()">
				<li class="user login">로그인</li>
				<li class="user join">회원가입</li>
			</sec:authorize>
			
			<sec:authorize access="isAuthenticated()">
				<li class="user mypage">
						<strong>MyPage</strong>
						<span>(<sec:authentication property="principal.email"/>)</span>
				</li>
				<li class="user logout">
					<f:form action="${rootPath}/user/logout" onclick="this.submit()">로그아웃</f:form>
				</li>
				<sec:authorize access="hasRole('ADMIN')">
					<li class="user admin">관리자</li>
				</sec:authorize>
			</sec:authorize>
			
		</ul>
	</nav>
</body>
</html>




