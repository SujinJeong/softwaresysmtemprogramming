<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>

<% Calendar todayCal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh:mm:ss");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영수증</title>
</head>
<body>
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
		<!--여기까지 왼쪽 메뉴 --> 		
		<td align="center" width="100%">
			<table style="width:70%">
				<tr>
					<td>${storeSession.store_name}</td>
					<td>${storeSession.store_num}</td>
				</tr>
				<tr>
 					<td><%=sdf.format(todayCal.getTime()) %></td>
				</tr>
				<tr><th>상품명</th><th>수량</th><th>가격</th></tr>
	
					<c:forEach var="sp" items="${sp}">
					<tr>
						<td align="center" width="45%">${sp.product_name}</td>
						<td align="center" width="45%">${sp.quantity}</td>
						<td align="center" width="45%">${sp.quantity * sp.list_price}</td>
					</tr>
					</c:forEach>
					
					<!-- 여기에 결제수단도 추가해주기 -->
					
				<tr align="center">
					<td>
						<input type="button" value="닫기" onclick="location.href='${pageContext.request.contextPath}/store/sale/remove'"/>
					</td>
				</tr>
			</table>
			</table>
		</td>
	</tr>
</table>
</body>
</html>