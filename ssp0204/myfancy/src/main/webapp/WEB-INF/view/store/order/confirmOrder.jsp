<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>발주 완료</title>
</head>
<body>
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
<h2 align = "center">정상적으로 발주가 완료되었습니다.</h2>

<form:form  action = "${pageContext.request.contextPath}/store/order/confirmedComplete">
	<table border="0" width="1200">
		<strong align = "center">발주 번호 : ${order.getOrder_id()} </strong><br><br>
		<tr><th>거래처명</th><th>상품명</th><th>수량</th><th>금액</th></tr>
		<c:forEach var="con" items="${orderProductList}">
			<tr>
				<td align="center">${con.supplierName}</td>	
				<td align="center">${con.productName}</td>
				<td align="center">${con.quantity}</td>
				<td align="center">${con.quantity*con.orderPrice}</td>
			</tr>
		</c:forEach>
		
	</table>
	<strong align = "center">총 발주금액 : ${order.getAmount()}원</strong><br><br>
	<strong align = "center">발주 날짜 : ${order.getOrder_date()}</strong><br><br>
		<input type="submit" value="확인"/>
</form:form>
</div>
</body>
</html>