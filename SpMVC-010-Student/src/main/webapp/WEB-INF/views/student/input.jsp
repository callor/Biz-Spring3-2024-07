<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<section class="student input">
		<form method="POST">
			<fieldset>
			<legend>학생정보 입력</legend>
			<div><label for="">학번</label><input type="text"></div>
    		<div><label for="">이름</label><input type="text"></div>
    		<div><label for="">학과</label><input type="text"></div>
    		<div><label for="">학년</label><input type="text"></div>
    		<div><label for="">전화번호</label><input type="text"></div>
    		<div><label for="">주소</label><input type="text"></div>
    		</fieldset>
		</form>
	</section>

</body>
</html>