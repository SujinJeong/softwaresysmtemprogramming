<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>

<title>직원 관리</title>
<script type="text/javascript">
    function commute() {
    	$.ajax({
            //contentType: "application/json;charset=UTF-8",
            type: "get",
            //data: ${emp_id},
            dataType:"text",
            accept : "application/json",
            url: "${pageContext.request.contextPath}/store/emp/employee/commuteClick?emp_id=${emp_id }",
            success: function (response) {
            	if (response == "") {
                    alert('하루에 두 번 출근하실 수 없습니다.');
            	} else {
               		alert(JSON.stringify(response));
               		window.location.replace("${pageContext.request.contextPath}/store/emp/commute?emp_id=${emp_id}");
            	}
            },
            error: function() {
                alert('근무시간 30분 이내에 퇴근할 수 없습니다.');
            }
         });
    }
</script>

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
	
		<h2>${emp_name}님의 출/퇴근 관리</h2>
		<br/>
			<button id="start" type="button" name="commute" onclick="commute();" >출/퇴근 기록</button>
			<%-- <input id="finish" type="button" name="finish" value="퇴근" onclick="location.href='${pageContext.request.contextPath}/store/emp/employee/finish?emp_id=${emp_id }'" />
			 --%><br/><br/>
			<table border="0" width="800">
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
							${commute.startStr}
						</td>
						<td align="center">
							<c:if test="${commute.worktimeOfDay > 0}">
							${commute.finishStr }
							</c:if>
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