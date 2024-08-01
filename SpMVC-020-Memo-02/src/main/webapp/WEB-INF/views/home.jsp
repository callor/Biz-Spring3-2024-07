<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content='width=device-width, initial-scale=1.0' />
<title>오늘은 나의 날</title>
<link rel="stylesheet" href="${rootPath}/static/css/main.css" />
<script>
	const rootPath = "${rootPath}"
</script>
<script src="https://kit.fontawesome.com/58b5d9133d.js" 
			crossorigin="anonymous"></script>
<script src="${rootPath}/static/js/main.js"></script>
</head>
<body>
	<h1>오늘은 내 인생의 가장 젊은날</h1>
	<section class="memo main">
		<article class='list'></article>
		<article class="sub"></article>
	</section>
	<footer>
		<address>CopyRight &copy; callor@callor.com</address>
	</footer>
</body>
</html>