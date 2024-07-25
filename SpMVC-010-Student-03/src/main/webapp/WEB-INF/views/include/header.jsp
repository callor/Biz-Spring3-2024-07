<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>	
<header>
	<h1>학생관리 시스템 2024</h1>
	<p>나라고등학교 학생관리 시스템</p>
</header>
<nav class="main">
	<ul>
		<li class="home"><a href="${rootPath}/">Home</a></li>
		<li class="notice"><a href="${rootPath}/bbs/notice">공지사항</a></li>
		<li class="student"><a href="${rootPath}/student">학생관리</a></li>
		<li class="login"><a href="${rootPath}/user/login">로그인</a></li>
		<li class="join"><a href="${rootPath}/user/join">회원가입</a></li>
	</ul>
</nav>