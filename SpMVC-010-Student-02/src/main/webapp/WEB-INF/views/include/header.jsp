<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />   
<header class="main">
	<img src="${rootPath}/static/images/mylogo.png" 
			alt='logo' width="150px" class="home"
			onClick="document.location.href=${rootPath}/"
	/>
	<h1>학사정보관리 시스템</h1>
	<div>
		<a href="${rootPath}/user/login">로그인</a>
		<a href="${rootPath}/user/join">회원가입</a>
	</div>
</header>