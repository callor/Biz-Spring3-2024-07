<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<link rel="stylesheet" href="${rootPath}/static/css/user/join.css"/>
<form class="user join">
	<fieldset>
		<legend>회원가입</legend>
		<div><input type="text" placeholder="USER NAME" /></div>
		<div><input type="password" placeholder="PASSWORD" /></div>
		<div><input type="text" placeholder="본명" /></div>
		<div><input type="text" placeholder="별명" /></div>
		<div><input type="button" value="회원가입" /></div>
	</fieldset>
</form>
