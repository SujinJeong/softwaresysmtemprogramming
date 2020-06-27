<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제창</title>
</head>
<body>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<h2 align="center" width="10%">통합 결제</h2>
<table border="0" width="100%">
	<tr align="center">
		<td align="center" width="10%">
			<aside id = "left">
			<%@ include file="../left.jsp" %>
			</aside>
		</td>
		<!-- 여기까지는 왼쪽 메뉴 출력 -->
		<td align="center" width="10%">
		<form:form modelAttribute="sessionSaleCart" action="payment">
			<table style="width:70%">
				<tr><th>결제할 금액</th>
				   <td align="center" width="45%"><input type="text"></td>
				</tr>
				<tr><th>카드번호</th>
					<td align="center" width="45%"><input type="text"></td>
				</tr>
				<tr>
				<td align="center" width="45%">
				<input type="button" value="카드" onclick="location.href='${pageContext.request.contextPath}/store/sale/payment?'"/>
				</td>
				<td align="center" width="45%">
				<input type="button" value="현금" onclick="location.href='${pageContext.request.contextPath}/store/sale/payment?'"/>
				</td>			
				</tr>
			</table>
				<table style="width:70%">
				<tr><th>결제할 금액</th>
				   <td align="center" width="45%"><input type="text"></td>
				</tr>
				<tr><th>카드번호</th>
					<td align="center" width="45%"><input type="text"></td>
				</tr>
				<tr>
				<td align="center" width="45%">
				<input type="button" value="카드" onclick="location.href='${pageContext.request.contextPath}/store/sale/payment?'"/>
				</td>
				<td align="center" width="45%">
				<input type="button" value="현금" onclick="location.href='${pageContext.request.contextPath}/store/sale/payment?'"/>
				</td>			
				</tr>
			</table>
			</form:form>
		</td>
		<tr>
			<td>
			<input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/store/sale/remove'"/>
			<input type="submit" value="결제완료"/>
			</td>
		</tr>
	</tr>
</table>
세션카트 존재 여부 : <%=session.getAttribute("sessionSaleCart") != null?"존재":"없음" %>
</body>
</html>