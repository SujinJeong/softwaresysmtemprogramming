<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입고관리-차이수량 조회</title>
</head>
<body>
	<aside id="header">
		<%@ include file="../header.jsp"%>
	</aside>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center" width="10%">
				<aside id="left">
					<%@ include file="../left.jsp"%>
				</aside>
			</td>
			<td align="center" width="90%">
				<h4>${storeSession.store_name} 차이수량 조회</h4>
				<table border="1">
					<tr>
						<td>입고날짜</td>
						<td>물품명</td>
						<td>입고수량</td>
						<td>발주수량</td>
						<td>차이수량</td>
					</tr>
					<c:forEach var="loss" items="${loss}">
						<tr>
							<td><c:out value="${loss.receive_date}" /></td>
							<td><c:out value="${loss.product_name}" /></td>
							<td><c:out value="${loss.receive_quantity}" /></td>
							<td><c:out value="${loss.order_quantity}" /></td>
							<td><c:out value="${loss.loss_quantity}" /></td>
						</tr>
					</c:forEach>
				</table>
				<button type="button" id="reorder" name="reorder" onclick="location.href='${pageContext.request.contextPath}/store/receive/reorder'">재발주</button>
			</td>
		</tr>
	</table>
</body>