<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
			prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" 
			prefix="tiles"%>
<c:set value="${pageContext.request.contextPath}" var="rootPath"/>

<!DOCTYPE html>
<html lang="ko">
  <tiles:insertAttribute name="head"/>
  <body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="content" />
  </body>
</html>
