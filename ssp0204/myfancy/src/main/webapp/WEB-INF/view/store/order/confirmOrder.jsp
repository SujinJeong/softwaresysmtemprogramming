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
<form:form  action = "/store/order/confirmedComplete">
<h2 align = "center">정상적으로 발주가 완료되었습니다.</h2>
발주 번호 : ${order.getOrder_id()} <br>
<p><th>거래처명</th><th>상품명</th><th>수량</th><th>금액</th></p>
<c:forEach var="orderProductList" items="${orderProductList} ">
	<tr>
		<td>${orderProductList[0]}</td>
		<td>${orderProductList[1]}</td>
		<td>${orderProductList[2]}</td>
		<td>${orderProductList[3]}</td>
	</tr>
</c:forEach>

총 발주금액 : ${order.getAmount()}원<br>
발주 날짜 : ${order.getOrder_date()}<br>
<input type="submit" value="확인"/>
</form:form>
</body>
</html>