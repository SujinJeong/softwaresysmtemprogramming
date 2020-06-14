<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>직원 관리</title>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<aside id = "left">
<%@ include file="../left.jsp" %>
</aside>

<div align="center">
	<button type="button" id="employer" name="employer" onclick="location.href('${pageContext.request.contextPath}/store/emp/employer')">관리자</button>
	<br><br>
	<button type="button" id="employee" name="employee" onclick="alert('employee')">직원</button>
</div>