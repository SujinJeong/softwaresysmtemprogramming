<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>발주 화면</title>
</head>
<body>
<aside id = "left">
<%@ include file="../left.jsp" %>
</aside>
<section>
<form:form modelAttribute="orderProducts" action = "/store/order/addOrderProducts">
	거래처 : <form:select path="supplierList" items="${supplierList}" onchange="<c:url value = "/store/order/selected"/>"/><br>
	<tr><th>상품명</th><th>발주단가</th><th>수량</th></tr>
	<c:forEach var="orderProducts" items="${orderProducts} ">
			<tr>
				<td>${orderProducts.product_name}</td>
				<td>${orderProducts.order_price}</td>
				<td><form:input path="quantity"/></td>
			</tr>
	</c:forEach>
	<input type="submit" value="담기"/>
</form:form>
</section>
<aside id = "right">
발주 번호 : ${order.getOrder_id()} <br>
<tr><th>거래처명</th><th>상품명</th><th>수량</th><th>금액</th></tr>
<c:forEach var="cartList" items="${cartList} ">
	<tr>
		<td>${supplierName}</td>
		<td>${cartList.product_name}</td>
		<td>${cartList.quantity}</td>
		<td>${cartList.order_price} * ${cartList.quantity}</td>
	</tr>
</c:forEach>

총 발주금액 : ${order.getAmount()}원<br>
발주 날짜 : ${order.getOrder_date()}<br>
<form:form action = "/store/order/requestOrder">
<input type="submit" value="발주 등록" />
</form:form>
<button type = "button" onclick = "location.href='Main.jsp'">취소</button>
</aside>
</body>
</html>