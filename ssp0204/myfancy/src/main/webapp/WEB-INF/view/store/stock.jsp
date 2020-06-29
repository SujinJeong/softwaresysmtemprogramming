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
				<h4><font color="GREEN">${storeSession.store_name} 재고현황</font></h4>
				<table border="1">
					<tr>
						<td><strong>상품번호</strong></td>
						<td><strong>상품명</strong></td>
						<td><strong>수량</strong></td>
					</tr>
					<c:forEach var="stock" items="${stock}">
						<tr>
							<td><c:out value="${stock.product_id}" /></td>
							<td><c:out value="${stock.product_name}" /></td>
							<td>
								<c:choose>
									<c:when test="${stock.quantity eq 0}">
									<font color="RED"><c:out value="${stock.quantity}" />(판매불가)</font>
									</c:when>
									<c:when test="${stock.quantity lt 5 && stock.quantity gt 0}">
									<font color="BLUE"><c:out value="${stock.quantity}" />(발주필요)</font>
									</c:when>
									<c:otherwise>
									<c:out value="${stock.quantity}" />
									</c:otherwise>
								</c:choose>
								</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>

</body>
</html>