<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<link rel="stylesheet" href="${rootPath}/static/css/student/detail.css" />
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<section class="student detail">
		<table>
			<tr><th>학번</th><td>${ST.st_num}</td><tr>
			<tr><th>이름</th><td>${ST.st_name}</td><tr>
			<tr><th>학과</th><td>${ST.st_dept}</td><tr>
			<tr><th>학년</th><td>${ST.st_grade}</td><tr>
			<tr><th>전화번호</th><td>${ST.st_tel}</td><tr>
			<tr><th>주소</th><td>${ST.st_addr}</td><tr>
		</table>
		<div>
			<button class="list">리스트로</button>
			<button class="update">수정</button>
			<button class="delete" data-st_num="${ST.st_num}">삭제</button>
		</div>
	</section>
</body>
</html>