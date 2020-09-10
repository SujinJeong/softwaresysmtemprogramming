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
	
		<h2><a href="${pageContext.request.contextPath}/store/emp/employer/salary?move=-1&year=${year}&month=${month}">&lt;</a>
		&nbsp;&nbsp;${year }년 ${month }월&nbsp;&nbsp;
		<c:if test="${!now}">
			<a href="${pageContext.request.contextPath}/store/emp/employer/salary?move=1&year=${year}&month=${month}">&gt;</a>
		</c:if>
		</h2>
		<br/>
			<table border="0" width="800">
				<tr align="center">
					<th align="center">
						ID
					</th>
					<th align="center">
						이름
					</th>
					<th align="center">
						계좌번호
					</th>
					<th align="center">
						근무시간
					</th>
					<th align="center">
						시급
					</th>
					<th align="center">
						월급
					</th>
				</tr>
				<c:forEach var="emp" items="${employeeSalaryList }">
					<tr align="center">
						<td align="center">
							${emp.emp_id }
						</td>
						<td align="center">
							${emp.emp_name }
						</td>
						<td align="center">
							${emp.bankaccount }
						</td>
						<td align="center">
							${emp.worktime }
						</td>
						<td align="center">
							${emp.salary }
						</td>
						<td align="center">
							${emp.amount }
						</td>
					</tr>
				</c:forEach>
			</table>
       </td>
   </tr>
</table>
</div>