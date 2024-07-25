<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />
<link rel="stylesheet" href="${rootPath}/static/css/user/join.css"/>
<form class="user join" method="POST">
	<fieldset>
		<legend>회원가입</legend>
		<c:if test="${JOIN_MSG == 'FAIL' } ">
			<h3>회원가입에 실패 했습니다</h3>
		</c:if>
		
		<input type="text" placeholder="USER NAME" name="username"/>
		<span>*</span>
		
		<input type="password" placeholder="PASSWORD" name="password"/>
		<span>*</span>
		
		<input type="text" placeholder="본명" name="name" />
		<span>*</span>
		
		<input type="text" placeholder="별명" name="nick"/>
		<span>*</span>
		
		<input type="button" value="회원가입" />
	</fieldset>
</form>
