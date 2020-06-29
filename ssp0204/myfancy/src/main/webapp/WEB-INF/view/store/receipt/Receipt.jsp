<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
	type="text/css" />
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!DOCTYPE html html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>영수증 조회</title>
<script type="text/javascript">
	$(document).ready(
			function() {
				$.datepicker.setDefaults($.datepicker.regional['ko']);
				$("#startDate")
						.datepicker(
								{
									changeMonth : true,
									changeYear : true,
									nextText : '다음 달',
									prevText : '이전 달',
									dayNames : [ '일요일', '월요일', '화요일', '수요일',
											'목요일', '금요일', '토요일' ],
									dayNamesMin : [ '일', '월', '화', '수', '목',
											'금', '토' ],
									monthNamesShort : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ],
									monthNames : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ],
									dateFormat : "yymmdd",
									maxDate : 0, // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
									onClose : function(selectedDate) {
										//시작일(startDate) datepicker가 닫힐때
										//종료일(endDate)의 선택할수있는 최소 날짜(minDate)를 선택한 시작일로 지정
										$("#endDate").datepicker("option",
												"minDate", selectedDate);
									}

								});
				$("#endDate")
						.datepicker(
								{
									changeMonth : true,
									changeYear : true,
									nextText : '다음 달',
									prevText : '이전 달',
									dayNames : [ '일요일', '월요일', '화요일', '수요일',
											'목요일', '금요일', '토요일' ],
									dayNamesMin : [ '일', '월', '화', '수', '목',
											'금', '토' ],
									monthNamesShort : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ],
									monthNames : [ '1월', '2월', '3월', '4월',
											'5월', '6월', '7월', '8월', '9월',
											'10월', '11월', '12월' ],
									dateFormat : "yymmdd",
									maxDate : 0, // 선택할수있는 최대날짜, ( 0 : 오늘 이후 날짜 선택 불가)
									onClose : function(selectedDate) {
										// 종료일(endDate) datepicker가 닫힐때
										// 시작일(startDate)의 선택할수있는 최대 날짜(maxDate)를 선택한 시작일로 지정
										$("#startDate").datepicker("option",
												"maxDate", selectedDate);
									}

								});
			});
</script>

</head>
<body>

	<aside id="header">
		<%@ include file="../header.jsp"%>
	</aside>
	<table border="0" width="100%">
		<tr align="center">
			<td align="center" width="10%">
				<aside id="left">
					<%@ include file="../left.jsp"%>
				</aside>
			</td>
			<td>
					<form action="${pageContext.request.contextPath}/store/receipt/check">
						판매번호 : <input type="text" name="sale_id" id="sale_id" />
						판매날짜 : <input type="text" name="sale_time" id="sale_time"/> <%-- value="${receipt.sale_time}"  --%>
						<input type="submit" value="조회" />
					</form>
					<table border="1" width="100%">
						<tr>
							<th>판매번호</th>
							<th>판매시간</th>
							<th>총금액</th>
						</tr>
						
						<c:forEach var="receipt" items="${receipts}" >
							<tr>
								<td>${receipt.sale_id}</td>
								<td>${receipt.sale_time}</td>
								<td>${receipt.totalamount}</td>
							</tr>
						</c:forEach>
					</table>
			</td>
			<td align="center" width="45%">
			<font size="5px">영수증</font>
			<br>
			상품명: ${searchproduct.product_name}<br>
			1개당 가격: ${searchproduct.list_price}<br>
			수량: ${searchproduct.quantity}<br>
			총급액: ${searchproduct.list_price} * ${searchproduct.quantity}<br>
		<br>
	</table>
</body>
</html>