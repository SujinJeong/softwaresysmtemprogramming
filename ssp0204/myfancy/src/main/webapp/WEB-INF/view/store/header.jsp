<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div align="right">
<form action="${pageContext.request.contextPath}/logout">
	${storeSession.store_name } 환영합니다. &nbsp;
	<input type="submit" value="로그아웃" />
	&nbsp;
</form>
</div>
<div align="center">
<h1 class="title">
   <font size="100"><a href="${pageContext.request.contextPath}/main">DD</a></font>
</h1>
</div>
