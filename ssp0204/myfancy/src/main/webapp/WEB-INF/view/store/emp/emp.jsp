<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>직원 관리</title>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<table border="0" width="100%">
	<tr align="center">
		<td align="center" width="10%">
			<aside id = "left">
			<%@ include file="../left.jsp" %>
			</aside>
		</td>
		<td align="center" width="90%">
			<form method="post" action="${pageContext.request.contextPath}/store/emp/employer">
				관리자 비밀번호 : <input type="password" name="employer" />
				<input type="submit" value="관리자" />
			</form>
			<br><br>
			<form method="get" action="${pageContext.request.contextPath}/store/emp/commute">
				직원 아이디 : <input type="text" name="emp_id" />
				<input type="submit" value="직원" />
			</form>
		</td>
	</tr>
</table>