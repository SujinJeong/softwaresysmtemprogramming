<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품판매</title>
<script type="text/javascript">
	function callFunction(id) {
			$.ajax({
				type: "get",
				dataType:"text",
				url:"${pageContext.request.contextPath}/store/sale/addSaleProducts?product_id=" + id,
				success: function(response) {
					window.location.replace("${pageContext.request.contextPath}/store/sale/view");
				},
				error: function() {
					alert('선택하신 상품의 재고가 부족합니다.');
					window.location.replace("${pageContext.request.contextPath}/store/sale/view");
					}
			})	
	}

</script>
</head>
<body>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<table border="0" width="800">
	<tr align="center">
		<td align="center" width="100">
			<aside id = "left">
			<%@ include file="../left.jsp" %>
			</aside>
		</td>
		<td align="center" width="300">
			<table style="width:50%">
			   <tr align="center" width="45%"><th>상품명</th><th >가격</th></tr>
			   <c:forEach var="product" items="${productList}">
			         <tr align="center" width="30%">
			            <td align="center" width="30%">
			            <a href="javascript:void(0);" onclick="callFunction(${product.product_id});">${product.product_name}</a></td>
			            <td align="center" width="30%">${product.list_price}</td>
			         </tr>
			   </c:forEach>
			</table>
			<td>
			  <table style="width:100">
			   	<tr><th>품절 상품</th></tr>
			    <c:forEach var="soldout" items="${soldoutList}">
			         <tr align="center" width="70%">
			            <td align="center" width="70%">${soldout.product_name}</td>
			         </tr>
			   </c:forEach>
			   </table>
			  </td>
			<!-- 여기까지가 가운데 항목 -->
		</td>
		<td align="center" width="300">
			<form:form modelAttribute="sessionSaleCart" action="payment?payment_code=0&amount=${sessionSaleCart.getSubSaleTotal()}">
				<table style="width:70%">
				   <tr><th>상품명</th><th>수량</th><th>가격</th></tr>
					<c:forEach var="cart" items="${sessionSaleCart.cartList}">
						<tr>
							<td align="center" width="45%">${cart.key.product_name}</td>
							<td align="center" width="45%">${cart.value}</td>
							<td id="price" align="center" width="45%">${cart.key.list_price*cart.value}</td>
						</tr>
					</c:forEach>
				</table>
			총 가격 : ${sessionSaleCart.getSubSaleTotal()}
			<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/store/sale/remove'"/>
			<input type="submit" value="결제"/>
			</form:form>
		</td>
		</tr>
</table>	
</body>
</html>