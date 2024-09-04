<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content='width=device-width, initial-scale=1.0' />
<title>Insert title here</title>
<style>
	div.error {
		background-color: red;
		color:yellow;
		text-align: center;
	}
</style>
</head>
<body>
	<h1>로그인</h1>
	<f:form>
		<c:if test="${param.error != null }"><div>${param.error}</div></c:if>
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION !=null }">
			<div class="error">${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
		</c:if>
	
		<input name="u_name" placeholder="USERNAME" />
		<input name="u_pass" placeholder="PASSWORD" 
					type="password" />
		<input type="submit" value="로그인" />
	</f:form>
</body>
</html>