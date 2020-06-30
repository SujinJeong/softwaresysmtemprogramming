<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<<<<<< HEAD
<title>발주관리</title>
<style TYPE="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
td {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #595959;
	text-align: center;
	height: 80px;
}
=======
<title>발주 화면</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
>>>>>>> refs/remotes/origin/develop

<<<<<<< HEAD
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
 <script>
=======
	
>>>>>>> refs/remotes/origin/develop

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
		
		<td>
		<font color="GREEN" size="8px">${storeSession.store_name} 발주관리</font>
		<br><br><br>
		<table>
		<tr>
		<td>
		거래처 : <select name="supplier"><br><br>
	  	<option value ="">거래처 선택</option>
		<c:forEach var="supplierList" items="${supplierList}">
		  <option value="${supplierList.supplier_name}" <c:if test="${supplierList.supplier_id eq id}">selected</c:if> onclick = "location.href='${pageContext.request.contextPath}/store/order/selected/${supplierList.supplier_id}'" >${supplierList.supplier_name}</option> 
		</c:forEach>
		</select>
		
		<form id="orderProducts"  method="post" action="${pageContext.request.contextPath}/store/order/addOrderProducts?supplierId=${id}">
			<table id = "productsTable" border="0" class="table">
				<tr><th>상품명</th><th>발주단가</th><th>수량</th></tr>
				<c:forEach var="orderProduct" items="${orderProducts}" varStatus="i">
					<c:if test="${orderProduct.supplierId eq id}">
						<tr>
							<td >${orderProduct.productName}</td>
							<td>${orderProduct.orderPrice}</td>
							<td><input name="${i.index}" value="${orderProduct.quantity}" style="width:30px"/></td> 
						</tr>
				</c:if>
				</c:forEach>
			</table>
			<input type = "submit" value="담기"/>			
		</form>
		
		</td>
		
		<td align="center" width = "45%">
		<aside id = "right">
		발주 번호 : ${order.getOrder_id()} <br>
		<table border="0" class="hidden">
			<tr><th>거래처명</th><th>상품명</th><th>수량</th><th>금액</th></tr>
			<c:forEach var="cartList" items="${cartList}">
			<tr>
				<td>${cartList.supplierName}</td>
				<td>${cartList.productName}</td>
				<td>${cartList.quantity}</td>
				<td>${cartList.quantity*cartList.orderPrice}</td>
			</tr>
			</c:forEach>
		</table>
	총 발주금액 : ${order.getAmount()}원<br>
	발주 날짜 : ${order.getOrder_date()}<br>
	<input type="button" value = "발주 등록" onclick = "location.href='${pageContext.request.contextPath}/store/order/requestOrder'"/>
	<input type="button" value = "취소" onclick = "location.href='/myfancy/main'"/>
</aside>
</td>
</tr>
</table>
</td>
</tr>
</table>

</body>
</html>