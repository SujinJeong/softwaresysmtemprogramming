
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
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
<title>직원 등록</title>
<script type="text/javascript">
    function removeCheck() {
    	if (confirm("정말 삭제하시겠습니까?") == true) {
    		$.ajax({
                type: "get",
                dataType:"text",
                url: "${pageContext.request.contextPath}/store/emp/employer/remove/${employeeForm.employee.emp_id }",
             	success: function() {
             		window.location.replace("${pageContext.request.contextPath}/store/emp/employer");
             	}
    		});
    	}
    	
    }
    
    function updateCheck() {
    	if (confirm("입력한 정보로 수정하시겠습니까?") == true) {
    		$.ajax({
                type: "post",
                dataType:"text",
                url: "${pageContext.request.contextPath}/store/emp/employer/update/${employeeForm.employee.emp_id }"
             });
    	}
    }
</script>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<div id="body" align="center">
<table width="1200">
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
			<h3>직원 수정</h3>
			<div align="center">
			<form:form modelAttribute="employeeForm" method="post" action="${pageContext.request.contextPath}/store/emp/employer/update/${employeeForm.employee.emp_id }">
				<table border="1" style="width:600;height:380;align:center">
					<tr align="center">
						<td align="center">
							<br/><br/>
							<label for="id">ID</label>: 
							<form:input path="employee.emp_id" value="${employeeForm.employee.emp_id }" readonly="true"/>
							<form:errors path="employee.emp_id" />
							<br/><br/><br/>
							<label for="name">이름</label>: 
							<form:input path="employee.emp_name" value="${employeeForm.employee.emp_name }"/>
							<form:errors path="employee.emp_name" />
							<br/><br/><br/>
							<label for="address">주소</label>: 
							<form:input path="employee.address" value="${employeeForm.employee.address }"/>
							<form:errors path="employee.address" />
							<br/><br/><br/>
							<label for="phone">핸드폰 번호</label>: 
							<form:input path="employee.phonenum" value="${employeeForm.employee.phonenum }"/>
							<form:errors path="employee.phonenum" />
							<br/><br/><br/>
							<label for="email">e-mail</label>: 
							<form:input path="employee.email" value="${employeeForm.employee.email }"/>
							<form:errors path="employee.email" />
							<br/><br/><br/>
							<label for="worktime">근무시간</label>: 
							<form:input path="employee.worktime" value="${employeeForm.employee.worktime }"/>
							<form:errors path="employee.worktime" />
							<br/><br/><br/>
							<label for="bankaccount">계좌번호</label>: 
							<form:input path="employee.bankaccount" value="${employeeForm.employee.bankaccount }"/>
							<form:errors path="employee.bankaccount" />
							<br/><br/><br/>
							<label for="salary">시급</label>: 
							<form:input path="employee.salary" value="${employeeForm.employee.salary }"/>
							<form:errors path="employee.salary" />
							<br/><br/><br/>
							<input type="submit" value="수정하기" onclick="updateCheck();" />
							<button type="button" onclick="removeCheck();" >직원삭제</button>
							<br/><br/>
						</td>
					</tr>
	</table>
	</form:form>
	</div>
		</td>
		</tr>
</table>
</div>