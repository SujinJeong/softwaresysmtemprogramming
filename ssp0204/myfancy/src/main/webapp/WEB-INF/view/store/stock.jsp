<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@ page import="com.dongduk.myfancy.domain.Stock"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>재고현황</title>
</head>
<body>
	<aside id="header">
		<%@ include file="header.jsp"%>
	</aside>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center" width="10%">
				<aside id="left">
					<%@ include file="left.jsp"%>
				</aside>
			</td>
			<td align="center" width="90%">
				<h1>${storeSession.store_name}재고현황</h1>
				<table border="1">
					<tr>
						<td>상품번호</td>
						<td>상품명</td>
						<td>수량</td>
					</tr>
					<c:forEach var="stock" items="${stock}">
						<tr>
							<td><c:out value="${stock.product_id}" /></td>
							<td><c:out value="${stock.product_name}" /></td>
							<td><c:if test="${stock.quantity lt 30}">
									<font color="red"></font>
								</c:if> <c:out value="${stock.quantity}" /></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>