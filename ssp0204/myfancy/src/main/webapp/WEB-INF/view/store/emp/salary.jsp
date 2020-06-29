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
			<table border="0" width="500">
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