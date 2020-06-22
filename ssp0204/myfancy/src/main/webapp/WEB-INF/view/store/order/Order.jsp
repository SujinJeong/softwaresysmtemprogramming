<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>발주 화면</title>

 <script>

//  function selected(){
// 	 System.out.println($("#supplierList option:selected").val());
// 	 request.setAttribute("supplierList",$("#supplierList option:selected").val()); 
// 	 response.sendRedirect(${pageContext.request.contextPath}/store/order/selected);
// 	 }
// 	$(function(){
// 		$("#supplierList").change(function(){
// 			request.setAttribute("supplierList",$("#supplierList option:selected").val()); 
// 			response.sendRedirect(${pageContext.request.contextPath}/store/order/selected);
// 			});
// 		});
</script> 
</head>
<body>
<table border="0" width="100%">
	<aside id = "header">
		<%@ include file="../header.jsp" %>
	</aside>
	<tr align = "center">
		<td align="center" width="10%">
			<aside id = "left">
				<%@ include file="../left.jsp" %>
			</aside>
		</td>
		<td align="center" width="45%">
		<table>
			<tr>
				<td>
	거래처 : <select name="supplier"><br>

		<c:forEach var="supplierList" items="${supplierList}">
		<option value="${supplierList.supplier_name}" onclick = "location.href='${pageContext.request.contextPath}/store/order/selected/${supplierList.supplier_name}'">${supplierList.supplier_name}</option> 

 <!-- <option value="${supplierList.supplier_name}" onchange="selected()">${supplierList.supplier_name}</option> -->
		</c:forEach>
		</select>
		
			<form:form modelAttribute="orderProducts" action = "${pageContext.request.contextPath}/store/order/addOrderProducts">
			<table border="0">
				<tr><th>상품명</th><th>발주단가</th><th>수량</th></tr>
				<c:forEach var="orderProducts" items="${orderProducts}">
				<tr>
					<td>${orderProducts.product_name}</td>
					<td>${orderProducts.order_price}</td>
					<td><input type="text" value="${orderProducts.quantity}" style="width:30px"/></td>
				</tr>
				</c:forEach>
			</table>
			<input type="submit" value="담기"/>
			</form:form>
		</td>
		<td align="center" width = "45%">
		<aside id = "right">
		발주 번호 : ${order.getOrder_id()} <br>
		<table border="0">
			<tr><th>거래처명</th><th>상품명</th><th>수량</th><th>금액</th></tr>
			<c:forEach var="cartList" items="${cartList}">
			<tr>
				<td>${supplierName}</td>
				<td>${cartList.product_name}</td>
				<td>${cartList.quantity}</td>
				<td>${cartList.order_price} * ${cartList.quantity}</td>
			</tr>
			</c:forEach>
		</table>
총 발주금액 : ${order.getAmount()}원<br>
발주 날짜 : ${order.getOrder_date()}<br>
<form:form action = "store/order/requestOrder">
	<input type="submit" value="발주 등록" />
</form:form>
	<button type = "button" onclick = "location.href='Main.jsp'">취소</button>
</aside>
</td></tr></table>
</td>
</tr>
</table>
</body>
</html>