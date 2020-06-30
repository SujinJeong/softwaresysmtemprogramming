<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
	h1 {
	font-family: 'Jeju Gothic', sans-serif;
	}
</style>
<div id="right" align="right">
<form action="${pageContext.request.contextPath}/logout">
	${storeSession.store_name } 환영합니다. &nbsp;
	<input type="submit" value="로그아웃" />
	&nbsp;
</form>
</div>
<div id="header_div" align="center">
<h1 class="title">
	<img src="${pageContext.request.contextPath}/images/logo2.GIF" width="50" height="50"/>
   <font size="70px"><a href="${pageContext.request.contextPath}/main" style="background-color:#e2b9ff">DD</a>
	</font>
	<img src="${pageContext.request.contextPath}/images/logo2.GIF" width="50" height="50"/>
</h1>
</div>
