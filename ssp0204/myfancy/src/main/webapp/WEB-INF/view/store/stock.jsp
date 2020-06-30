<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.*"%>
<%@ page import="com.dongduk.myfancy.domain.Stock"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>재고현황</title>
<style TYPE="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
td {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #595959;
	text-align: center;
	height: 80px;
}

tr {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #000000;
	text-align: center;
	height: 80px;
}
th {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 20pt;
	color: #000000;
	text-align: center;
	background-color: #f29886;
	height: 80px;
}
</style>
</head>
<body>
<table border="0" width="100%">
	<aside id="header">
		<%@ include file="header.jsp"%>
	</aside>
		<tr>
			<td width="10%">
				<aside id="left">
					<%@ include file="left.jsp"%>
				</aside>
			</td>
			<td width="50%">
				<font color="GREEN" size="8px">${storeSession.store_name} 재고현황</font>
				<br><br>
				<table width="80%" border="1" cellspacing="1" cellpadding="1"
				align="center" style="border: 1px solid black">
					<tr align="center">
						<th>상품번호</th>
						<th>상품명</th>
						<th>수량</th>
					</tr>
					<c:forEach var="stock" items="${stock}">
						<tr align="center">
							<td><c:out value="${stock.product_id}" /></td>
							<td><c:out value="${stock.product_name}" /></td>
							<td>
								<c:choose>
									<c:when test="${stock.quantity eq 0}">
									<font color="RED"><c:out value="${stock.quantity}" /></font>
									</c:when>
									<c:when test="${stock.quantity lt 5 && stock.quantity gt 0}">
									<font color="BLUE"><c:out value="${stock.quantity}" /></font>
									</c:when>
									<c:otherwise>
									<c:out value="${stock.quantity}" />
									</c:otherwise>
								</c:choose>
								</td>
						</tr>
					</c:forEach>
				</table>
				<br>
				<font color="RED" size="4px">빨간색: 판매불가상품</font>
					<font color="BLUE" size="4px">파란색: 발주필요상품</font>
			</td>
		</tr>
	</table>
					

</body>
</html>