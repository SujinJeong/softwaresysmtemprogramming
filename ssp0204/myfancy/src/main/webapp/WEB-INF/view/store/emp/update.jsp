<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>직원 등록</title>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<hr>
<table width="100%">
	<tr align="center">
		<td align="center" width="10%">
			<aside id = "left">
			<%@ include file="../left.jsp" %>
			</aside>
		</td>
		<td align="center" width="50%">
			<br/>
	         <aside id = "emp_top">
			<%@ include file="emp_top.jsp" %>
			</aside>
			<br/>
			<h3>직원 수정</h3>
			<form:form modelAttribute="employeeForm" method="post" action="${pageContext.request.contextPath}/store/emp/employer/update/${employeeForm.employee.emp_id }">
				<table border="1" width="500">
					<tr align="center">
						<td align="center">
							<br/>
							<label for="id">ID</label>: 
							<form:input path="employee.emp_id" value="${employeeForm.employee.emp_id }" readonly="true"/>
							<form:errors path="employee.emp_id" />
							<br/><br/>
							<label for="name">이름</label>: 
							<form:input path="employee.emp_name" value="${employeeForm.employee.emp_name }"/>
							<form:errors path="employee.emp_name" />
							<br/><br/>
							<label for="address">주소</label>: 
							<form:input path="employee.address" value="${employeeForm.employee.address }"/>
							<form:errors path="employee.address" />
							<br/><br/>
							<label for="phone">핸드폰 번호</label>: 
							<form:input path="employee.phonenum" value="${employeeForm.employee.phonenum }"/>
							<form:errors path="employee.phonenum" />
							<br/><br/>
							<label for="email">e-mail</label>: 
							<form:input path="employee.email" value="${employeeForm.employee.email }"/>
							<form:errors path="employee.email" />
							<br/><br/>
							<label for="bankaccount">계좌번호</label>: 
							<form:input path="employee.bankaccount" value="${employeeForm.employee.bankaccount }"/>
							<form:errors path="employee.bankaccount" />
							<br/><br/>
							<input type="submit" value="수정하기"  />
							<input type="button" value="직원삭제" onclick="location.href='${pageContext.request.contextPath}/store/emp/employer/remove/${employeeForm.employee.emp_id }'" />
							<br/>
						</td>
					</tr>
	</table>
	</form:form>
		</td>
	</tr>
</table>