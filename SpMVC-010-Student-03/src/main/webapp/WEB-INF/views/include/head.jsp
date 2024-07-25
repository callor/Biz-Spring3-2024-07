<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>
	
<head>
	<meta charset="UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>학생관리시스템</title>
	<link href="${rootPath}/static/css/main.css" rel="stylesheet" />
	<link href="${rootPath}/static/css/student/list.css" rel="stylesheet" />
	<script>
		// JSP 에서 선언된 rootPath 변수를 *.js 파일에서 사용할수 있도록
		// JS 의 변수로 선언하기
		const rootPath = "${rootPath}"
	</script>
	<script src="${rootPath}/static/js/main.js"></script>
	<script src="${rootPath}/static/js/student/list.js"></script>
	<script src="${rootPath}/static/js/student/detail.js"></script>
	<script src="${rootPath}/static/js/student/input.js"></script>
	
	<script src="${rootPath}/static/js/user/join.js"></script>
	
</head>