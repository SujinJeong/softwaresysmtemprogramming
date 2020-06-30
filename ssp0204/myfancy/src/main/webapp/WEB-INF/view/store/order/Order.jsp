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
<!-- <table border="0" width="100%"> -->
	<aside id = "header">
		<%@ include file="../header.jsp" %>
	</aside>
	<style TYPE="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
td {
   align: center;
   font-family: 'Jeju Gothic', sans-serif;
   font-size: 15pt;
   color: #595959;
   text-align: center;
   height: 80px;
}

tr {
   align: center;
   font-family: 'Jeju Gothic', sans-serif;
   font-size: 15pt;
   color: #000000;
   text-align: center;
   height: 80px;
}
th {
   align: center;
   font-family: 'Jeju Gothic', sans-serif;
   font-size: 20pt;
   color: #000000;
   text-align: center;
   background-color: #f29886;
   height: 80px;
}
</style>
<div align="center">
<table border="0" width="1200">
	<tr align = "center">
		<td align="center" width="250">
			<aside id = "left">
				<%@ include file="../left.jsp" %>
			</aside>
		</td>
		<td width="150"></td>
		<td align="center" width="400">
			<table>
			거래처 : <select name="supplierList">
                 <option value ="">거래처 선택</option>
               <c:forEach var="supplierList" items="${supplierList}">
                 <option value="${supplierList.supplier_name}" onclick = "location.href='${pageContext.request.contextPath}/store/order/selected/${supplierList.supplier_id}'" <c:if test="${supplierList.supplier_id == id}">selected</c:if> >${supplierList.supplier_name}</option> 
               </c:forEach>
               </select>
			</table>
				<form id="orderProducts"  method="post" action="${pageContext.request.contextPath}/store/order/addOrderProducts?supplierId=${id}">
					<table id = "productsTable" border="0">
						<tr><th>상품명</th><th>발주단가</th><th>수량</th></tr>
						<c:forEach var="orderProduct" items="${orderProducts}" varStatus="i">
							<c:if test="${orderProduct.supplierId == id}">
								<tr align="center">
									<td align="center">
										${orderProduct.productName}
									</td>
									<td align="center">
										${orderProduct.orderPrice}
									</td>
									<td align="center">
										<input name="${i.index}" value="${orderProduct.quantity}" style="width:30px"/>
									</td>
								</tr>
							</c:if>
						</c:forEach>
					</table>
			<input type = "submit" value="담기"/>			
		</form>
		</td>
		
		<td align="center" width = "400">
			<aside id = "right">
				발주 번호 : ${order.getOrder_id()} <br>
				<table border="0" class="hidden">
					<tr><th>거래처명</th><th>상품명</th><th>수량</th><th>금액</th></tr>
					<c:forEach var="cartList" items="${cartList}">
						<tr>
							<td align="center">${cartList.supplierName}</td>
							<td align="center">${cartList.productName}</td>
							<td align="center">${cartList.quantity}</td>
							<td align="center">${cartList.quantity*cartList.orderPrice}</td>
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
</div>
</body>
</html>