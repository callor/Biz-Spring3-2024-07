<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<!DOCTYPE html>
<html lang="ko">
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<link rel="stylesheet" href="${rootPath}/static/css/student/input.css" />
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp"%>
	<section class="student input">
		<form method="POST">
			<fieldset>
			<legend>학생정보 입력</legend>
			<div><label for="st_num">학번</label><input type="text" id="st_num" name="st_num"></div>
    		<div><label for="st_name">이름</label><input type="text" id="st_name" name="st_name"></div>
    		<div><label for="st_dept">학과</label><input type="text" id="st_dept" name="st_dept"></div>
    		<div><label for="st_grade">학년</label><input type="text" id="st_grade" name="st_grade"></div>
    		<div><label for="st_tel">전화번호</label><input type="text" id="st_tel" name="st_tel"></div>
    		<div><label for="st_addr">주소</label><input type="text" id="st_addr" name="st_addr"></div>
    		<div><label></label><button type="button" class="save">저장</button></div>
    		</fieldset>
		</form>
	</section>

</body>
</html>