<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입고관리</title>
</head>
<body>
<h1>DD ${storeSession.store_id}점 입고관리</h1>
<table border="1">
	<tr>
		<td>발주날짜</td>
		<td>물품명</td>
		<td>업체명</td>
		<td>입고수량</td>
		<td>발주수량</td>
		<td>차이수량</td>
	</tr>
	<c:forEach var="receive" items="${receive}">
 	<tr>
	    <c:out value="${receive.order_date}" />
	    <c:out value="${receive.product_name}" />
	    <c:out value="${receive.supllier_name}" />
	    <c:out value="${receive.receive_quantity}" />
	    <c:out value="${receive.order_quantity}" />
	    <c:out value="${receive.loss_quantity}" />
	</tr>
	</c:forEach>
</table>
</body>
</html>