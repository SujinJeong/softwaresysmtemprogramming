<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>직원 등록</title>
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
			<form:form commandName="employeeForm" method="post">
			  <form:errors cssClass="error" /> <br><br>
			  
			  <table id="employee">
			    <tr>
			      <td>
			        <h3><font color="darkgreen">Employee Information</font></h3>
			        <table border="1">
			          <tr>
			            <td>Employee ID:</td>
			            <td>
			            <c:if test="${employeeForm.newAccount}">
			              <form:input path="employee.emp_name" />
			              <B><form:errors path="employee.emp_name" cssClass="error" /></B>
			            </c:if> 
			            <c:if test="${!employeeForm.newAccount}">
			              <c:out value="${employeeForm.employee.emp_name}" />
			            </c:if>
			            </td>
			          </tr>
			          <tr>
			            <td>New password:</td>
			            <td>
			              <form:password path="account.password" /> 
			              <B><form:errors path="account.password" cssClass="error" /></B></td>
			          </tr>
			          <tr>
			            <td>Repeat password:</td>
			            <td>
			              <form:password path="repeatedPassword" /> 
			              <B><form:errors path="repeatedPassword" cssClass="error" /></B></td>
			          </tr>
			        </table> 
			        
			        <%@ include file="IncludeEmployeeFields.jsp"%>
			
			      </td>
			    </tr>
			  </table>
			  <br />
			    <input type="image" src="../images/button_submit.gif" name="submit"
			      value="Save Account Information" />
			</form:form>
		</td>
	</tr>
</table>