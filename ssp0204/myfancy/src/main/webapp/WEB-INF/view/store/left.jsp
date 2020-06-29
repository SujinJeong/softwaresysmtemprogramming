<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
A:link{text-decoration:none;color:black;}
A:visited{text-decoration:none;color:black;}
A:hover{text-decoration:none;color:black;}
div#div_left {
	font-family: 'Jeju Gothic', sans-serif;
}
</style>

<div id="div_left" align="center">
<a href="${pageContext.request.contextPath}/main"><font size="8px">홈</font></a><br>
<a href="${pageContext.request.contextPath}/store/sale/view"><font size="8px">상품판매</font></a><br>
<a href="${pageContext.request.contextPath}/store/sales"><font size="8px">매출조회</font></a><br>
<a href="${pageContext.request.contextPath}/store/order"><font size="8px">발주관리</font></a><br>
<a href="${pageContext.request.contextPath}/store/receive"><font size="8px">입고관리</font></a><br>
<a href="${pageContext.request.contextPath}/store/stock"><font size="8px">재고현황</font></a><br>
<a href="${pageContext.request.contextPath}/store/emp"><font size="8px">직원관리</font></a><br>
<a href="${pageContext.request.contextPath}/store/receipt"><font size="8px">영수증조회</font></a><br>
</div>
