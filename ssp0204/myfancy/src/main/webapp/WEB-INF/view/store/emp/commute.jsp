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
	
		<h2>${emp_id}님의 출/퇴근 관리</h2>
		<br/>
			<input type="button" name="start" value="출근" onclick="location.href='${pageContext.request.contextPath}/store/emp/employee/start?emp_id=${emp_id }'" />
			<input type="button" name="finish" value="퇴근" onclick="location.href='${pageContext.request.contextPath}/store/emp/employee/finish?emp_id=${emp_id }'" />
			<table border="0" width="500">
				<tr align="center">
					<th align="center">
						COMMUTE_ID
					</th>
					<th align="center">
						EMP_ID
					</th>
					<th align="center">
						출근 시간
					</th>
					<th align="center">
						퇴근 시간
					</th>
					<th align="center">
						근무 시간
					</th>
				</tr>
				<c:forEach var="commute" items="${commuteList }">
					<tr align="center">
						<td align="center">
							${commute.commute_id }
						</td>
						<td align="center">
							${commute.emp_id }
						</td>
						<td align="center">
							${commute.start_time }
						</td>
						<td align="center">
							${commute.finish_time }
						</td>
						<td align="center">
							${commute.worktimeOfDay }
						</td>
					</tr>
				</c:forEach>
			</table>
       </td>
   </tr>
</table>