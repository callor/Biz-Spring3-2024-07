<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath" />   
 <form class="memo input">
 	<input type="hidden" name="m_seq" value="${MEMO.m_seq}"/>
 	<input type="hidden" name="m_date" value="${MEMO.m_date}"/>
 	<input type="hidden" name="m_time" value="${MEMO.m_time}"/>
 	<input name="m_subject" name="m_subject" value="${MEMO.m_subject}" 
 				placeholder="제목을 입력하세요" />
 	<textarea rows="10" cols="" name='m_content' 
 			placeholder="메모를 입력하세요">${MEMO.m_content}</textarea>
 	<input type="button" value="저장" class="btn-save"/>
 </form>