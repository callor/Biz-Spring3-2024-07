<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<link rel="stylesheet" href="${rootPath}/static/css/user/login.css" />
<form class="user login" method="POST">
	<h3>로그인</h3>
	<c:if test="${not empty MSG}">
		<h4>${MSG}</h4>
	</c:if>
	<input placeholder="USER NAME" name="username">
	<input placeholder="PASSWORD" name="password" type="password">
	<button>회원가입</button>
</form>
