<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<link rel="stylesheet" href="${rootPath}/static/css/student/detail.css" />
<section class="student detail">
	<table>
		<tr><th>학번</th><td>${ST.st_num}</td><tr>
		<tr><th>이름</th><td>${ST.st_name}</td><tr>
		<tr><th>학과</th><td>${ST.st_dept}</td><tr>
		<tr><th>학년</th><td>${ST.st_grade}</td><tr>
		<tr><th>전화번호</th><td>${ST.st_tel}</td><tr>
		<tr><th>주소</th><td>${ST.st_addr}</td><tr>
	</table>
	<ul class="score list">
		<li>
			<strong class="sbcode">과목코드</strong>
			<strong class="sbname">과목명</strong>
			<strong class="scor">성적</strong>
		</li>
		<c:forEach items="${ST.st_scores}" var="SCORE">
			<li>
				<span>${SCORE.sc_sbcode}</span>
				<span>${SCORE.sb_name}</span>
				<span>${SCORE.sc_score}</span>
			</li>
		</c:forEach>
	</ul>
	<div data-st_num="${ST.st_num}">
		<button class="list">리스트로</button>
		<button class="update">수정</button>
		<button class="delete">삭제</button>
	</div>
</section>











