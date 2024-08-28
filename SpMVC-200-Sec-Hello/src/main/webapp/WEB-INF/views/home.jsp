<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
			<li class="user login">로그인</li>
			<li class="user join">회원가입</li>
			<li class="user mypage">MyPage</li>
			<li class="user logout">로그아웃</li>
			<li class="user admin">관리자</li>
		</ul>
	</nav>
</body>
</html>




