<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div align="right">
<form action="logout">
	${storeSession.store_name } 환영합니다. &nbsp;
	<input type="submit" value="로그아웃" />
	&nbsp;
</form>
<!-- <button type="button" name="logout" onclick="logout()">로그아웃</button> -->
</div>
<h1 class="title">
   <a href="${pageContext.request.contextPath}/main">DD</a>
</h1>