<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>학생관리시스템</title>
    <link href="${rootPath}/static/css/main.css" rel="stylesheet"/>
    <script src="${rootPath}/static/js/main.js"></script>
  </head>
  <body>
  	<header>
  		<h1>학생관리 시스템 2024</h1>
  		<p>나라고등학교 학생관리 시스템</p>
  	</header>
  	<nav class="main">
  		<ul>
  			<li class="home">Home</li>
  			<li class="notice">공지사항</li>
  			<li class="login">로그인</li>
  			<li class="admin">관리자</li>
  		</ul>
  	</nav>
  	<section class="main">
  		<h2>학생정보</h2>
  		<table>
  			<tr>
  				<th>학번</th>
  				<th>이름</th>
  				<th>학과</th>
  				<th>학년</th>
  				<th>전화번호</th>
  				<th>주소</th>
  			</tr>
  		</table>
  		<div>
  			<a href="#">학생정보 등록</a>
  		</div>
  	</section>
  </body>
</html>
