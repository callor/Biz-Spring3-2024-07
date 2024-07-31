<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />   
 <form class="memo input">
 	<input name="m_subject" placeholder="제목을 입력하세요" />
 	<textarea rows="10" cols="" placeholder="메모를 입력하세요"></textarea>
 	<input type="button" value="저장" />
 </form>