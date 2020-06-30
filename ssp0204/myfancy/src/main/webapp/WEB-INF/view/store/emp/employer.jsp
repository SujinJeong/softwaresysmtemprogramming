<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>직원 관리</title>
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
	align: center;
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #595959;
	text-align: center;
	height: 80px;
}

tr {
	align: center;
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #000000;
	text-align: center;
	height: 80px;
}
th {
	align: center;
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
         <br/>
         <aside id = "emp_top">
		<%@ include file="emp_top.jsp" %>
		</aside>
		<br/>
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/store/emp/employer/register'">직원 등록</button><br/><br/>
		<form action="${pageContext.request.contextPath}/store/emp/employer/update">
		직원id : <input id="empId" type="text" name="empId"></input>
		<%-- <button type="button" onclick="location.href='${pageContext.request.contextPath}/store/emp/employer/update'">수정/삭제</button> --%>
		<input type="submit" value="수정/삭제" />
		</form>
		<br>
		<table border="0" width="800">
		<c:forEach var="emp" items="${employeeList }">
			<tr align="center">
				<td align="center">
					<a href="${pageContext.request.contextPath}/store/emp/employer/update/${emp.emp_id }">${emp.emp_id }</a>
				</td>
				<td align="center">
					${emp.emp_name }
				</td>
				<td align="center">
					${emp.phonenum }
				</td>
				<td align="center">
					${emp.address }
				</td>
			</tr>
		</c:forEach>
		</table>
       </td>
   </tr>
</table>
</div>
