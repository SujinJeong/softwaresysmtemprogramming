<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<title>입고관리</title>
<style TYPE="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
td {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #595959;
	text-align: center;
	height: 80px;
}

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
 <script type="text/javascript">
	 function post() {
		 	var rowData = new Array();
		 	var tdArr = new Array();
		 	var checkbox = $("input[type='checkbox']:checked");
		    var checkedValue = [];
		    // 체크된 체크박스 값을 가져옴
		    checkbox.each(function(i) {
		       checkedValue.push($(this).val()); //체크된 것만 뽑아서 배열에 push
			   var tr = checkbox.parent().parent().eq(i);
			   var td = tr.children();

			   //체크된 row의 모든 값을 배열에 담는다
			   rowData.push(tr.next());

			   //삭제하는데 필요한 order_id, product_id 가져오기
			   var order_id = td.eq(1).text();
			   var product_id = td.eq(2).text();

			   //가져온 값 배열에 담기
			   tdArr.push(order_id);
			   tdArr.push(product_id);

			});
			
			if (checkedValue.length == 0) {
				alert('입고 처리할 물품을 선택하세요')
			}
			else {
				if(confirm("선택하신 물품을 입고 처리 하시겠습니까?") == true)
					{
					    $.ajax({
					       //contentType: "application/json;charset=UTF-8",
					       type: "post",
					       data: {checkedArr: tdArr},
					       dataType:"text",
					       accept : "text/html",
					       url: "${pageContext.request.contextPath}/store/receive/confirm",
					       success: function (data) {
					    	   alert('입고되었습니다.');
					    	   location.href='${pageContext.request.contextPath}/store/receive';
					       },
					       error: function() {
					           alert('에러 발생');
					       }
					    });
					}
				else { //취소
					location.reload(true);
				}
		 }
	 }
</script>
</head>
<body>
<aside id="header">
	<%@ include file="../header.jsp"%>
</aside>
<table border="0" width="100%" align="center">
		<tr align="center">
			<td align="center" width="10%">
				<aside id="left">
					<%@ include file="../left.jsp"%>
				</aside>
			</td>
			<td align="center" width="50%">
				<font color="GREEN" size="8px">${storeSession.store_name} 입고관리</font>
				<br><br><br>
				<form>
				<table width="80%" border="1" cellspacing="1" cellpadding="1"
				align="center" style="border: 1px solid black">
					<tr>
						<th>입고여부</th>
						<th>발주번호</th>
						<th>상품번호</th>
						<th>발주날짜</th>
						<th>물품명</th>
						<th>발주수량</th>
					</tr>
					<c:forEach var="receive" items="${receive}">
						<tr>
						<td><input type="checkbox" id="check_receive" name="check_receive"></input></td>
							<td><c:out value="${receive.order_id}" /></td>
							<td><c:out value="${receive.product_id}" /></td>
							<td><c:out value="${receive.order_date}" /></td>
							<td><c:out value="${receive.product_name}" /></td>
							<td><c:out value="${receive.quantity}" /></td>
						</tr>
					</c:forEach>
				</table>
				</form>
				<br>
				<button type="button" id="confirmReceive" name="confirmReceive" onclick="post()">입고확인</button>
			</td>
		</tr>
	</table>
</body>

</html>