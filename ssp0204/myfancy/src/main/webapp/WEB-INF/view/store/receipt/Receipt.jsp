<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>  
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영수증 조회</title>
<script type="text/javascript">
    $(document).ready(function () {
            $.datepicker.setDefaults($.datepicker.regional['ko']); 
            $( "#startDate" ).datepicker({
                 changeMonth: true, 
                 changeYear: true,
                 nextText: '다음 달',
                 prevText: '이전 달', 
                 dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                 dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                 monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 dateFormat: "yymmdd",
                 maxDate: 0,                       // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                 onClose: function( selectedDate ) {    
                      //시작일(startDate) datepicker가 닫힐때
                      //종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
                     $("#endDate").datepicker( "option", "minDate", selectedDate );
                 }    
 
            });
            $( "#endDate" ).datepicker({
                 changeMonth: true, 
                 changeYear: true,
                 nextText: '다음 달',
                 prevText: '이전 달', 
                 dayNames: ['일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일'],
                 dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'], 
                 monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
                 dateFormat: "yymmdd",
                 maxDate: 0,                       // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                 onClose: function( selectedDate ) {    
                     // 종료일(endDate) datepicker가 닫힐때
                     // 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
                     $("#startDate").datepicker( "option", "maxDate", selectedDate );
                 }    
 
            });    
    });
</script>

</head>
<body>
<aside id = "left">
<%@ include file="../left.jsp" %>
</aside>
<section>
<form:form modelAttribute="receiptForm" action = "/store/receipt/check">
	<input type = "text" name = "date" id = "date1" /> 
	<input type = "text" name = "date" id = "date2" /> 
	판매번호 : <form:input path = "${receiptForm.sale_id}"/>
	<input type="submit" value="조회"/>
</form:form>
</section>
<aside id = "right">
<p align = "center">영수증</p><br>
<tr><th>상품명</th><th>수량</th><th>금액</th></tr>
<c:forEach var="cartList" items="${cartList} ">
	<tr>
		<td>${cartList.product_name}</td>
		<td>${cartList.quantity}</td>
		<td>${cartList.order_price} * ${cartList.quantity}</td>
	</tr>
</c:forEach>

총 금액 : ${order.getAmount()}원<br>
결제수단 : ${order.getOrder_date()}<br>
</aside>
</body>
</html>