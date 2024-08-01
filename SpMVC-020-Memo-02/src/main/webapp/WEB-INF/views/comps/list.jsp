<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />   
<div class="date-time">
	<input type="date" placeholder="작성일" name="m_date"/> 
	<input type="time" placeholder="작성시각" name="m_time" /> 
	<input type="button" value="새로작성" class="btn-new"/>
</div>
<ul class="memo-list">
	<c:forEach items="${MEMOS}" var="MEMO">
		<li data-seq="${MEMO.m_seq}">
			<i class="fa-solid fa-user"></i>
			<i>&#128511;</i>
			<span class="memo-content">${MEMO.m_subject}</span>
			<i class="memo-delete">&times;</i>
		</li>
	</c:forEach>
</ul>
 