<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>${ LIST[0] }</h2>
	<h2>${ LIST[1] }</h2>
	<h2>${ LIST[2] }</h2>
	<form method="POST">
		<input placeholder="이름을 입력하세요" name="c_name"/>
		<input placeholder="전화번호를 입력하세요" name="c_tel"/>
		<button>전송하기</button>
	</form>
</body>
</html>