<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
function enterkey() {
    if (window.event.keyCode == 13) {

         // 엔터키가 눌렸을 때 실행할 내용
         cart.value = document.getElementById("num").value;
    }
}
</script>
<meta charset="UTF-8">
<title>상품판매</title>
</head>
<body>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<table border="0" width="100%">
	<tr align="center">
		<td align="center" width="10%">
			<aside id = "left">
			<%@ include file="../left.jsp" %>
			</aside>
		</td>
		<td align="center" width="45%">
			<table style="width:70%">
			   <tr align="center" width="45%"><th>상품명</th><th >가격</th></tr>
			   <c:forEach var="product" items="${productList}">
			         <tr align="center" width="45%">
			            <td align="center" width="45%"><a href="<c:url value='addSaleProducts?product_id=${product.product_id}'/>">
			            ${product.product_name}</a></td>
			            <td align="center" width="45%">${product.list_price}</td>
			         </tr>
			   </c:forEach>
			</table>
		<td align="center" width="45%">
			<form:form modelAttribute="sessionSaleCart" action="payment?payment_code=0&amount=${sessionSaleCart.getSubSaleTotal()}">
				<table style="width:70%">
				   <tr><th>상품명</th><th>수량</th><th>가격</th></tr>
					<c:forEach var="cart" items="${sessionSaleCart.cartList}">
						<tr>
							<td align="center" width="45%">${cart.key.product_name}</td>
							<%-- <td align="center" width="45%">${cart.value}</td> --%>
							<td align="center" width="45%"><input type="text" id="num" value="${cart.value }" style="width:30px" onkeyup="enterkey();"></td>
							<td id="price" align="center" width="45%">${cart.key.list_price*cart.value}</td>
						</tr>
					</c:forEach>
				</table>
<%-- 			<label for="quantity">수량</label>
			<form:input path="quantity" /> --%>
			총 가격 : ${sessionSaleCart.getSubSaleTotal()}
			<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/store/sale/remove'"/>
			<input type="submit" value="결제"/>
			</form:form>
		</td>
		</tr>
</table>	
</body>
</html>