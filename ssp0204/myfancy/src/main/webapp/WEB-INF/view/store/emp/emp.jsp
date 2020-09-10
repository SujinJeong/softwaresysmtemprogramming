<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>직원관리</title>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<style TYPE="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
#body {
	align: center;
	font-family: 'Jeju Gothic', sans-serif;
	text-align: center;
}
td {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #595959;
	text-align: center;
	height: 80px;
}

tr {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #000000;
	text-align: center;
	height: 80px;
}
th {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 20pt;
	color: #000000;
	text-align: center;
	background-color: #f29886;
	height: 80px;
}
</style>
<div id="body" align="center">
<table border="0" width="1200">
	<tr align="center">
		<td align="center" width="250">
			<aside id = "left">
			<%@ include file="../left.jsp" %>
			</aside>
		</td>
		<td width="150"></td>
		<td align="center" width="800">
		<font color="GREEN" size="8px">${storeSession.store_name} 직원 관리</font>
		<br><br><br>
			<form method="post" action="${pageContext.request.contextPath}/store/emp/employer">
			관리자 비밀번호 : <input type="password" name="employer" />
			<input type="submit" value="관리자" />
			</form>
			<br><br>
			<form method="get" action="${pageContext.request.contextPath}/store/emp/commute">
				직원 아이디 : <input type="text" name="emp_id" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" required>
				<input type="submit" value="직원" />
			</form>
		</td>
	</tr>
</table>
</div>