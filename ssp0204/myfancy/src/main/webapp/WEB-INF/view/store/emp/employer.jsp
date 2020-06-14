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
         <aside id = "emp_top">
		<%@ include file="emp_top.jsp" %>
		</aside>
		<button type="button" onclick="location.href('registerEmp.jsp')">등록</button>
		<button type="button" onclick="location.href('updateEmp.jsp')">수정/삭제</button>
		<br>
		<table border="0">
		<c:forEach var="emp" items="${employeeList }">
			<tr align="center">
				<td align="center">
					<a href="">${emp.emp_id }</a>
				</td>
				<td align="center">
					${emp.emp_name }</a>
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
