<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<meta charset="UTF-8">
<title>입고관리</title>

<%-- <!-- <!--  <script type="text/javascript"> --> -->
<!-- // 	 function post() { -->
<!-- // 		 	var checkbox = $("input[type='checkbox']:checked"); -->
<!-- // 		    var checkedValue = []; -->
<!-- // 		    checkbox.each(function(i) { -->
<!-- // 			    checkedValue.push($(this).val()); //체크된 것만 뽑아서 배열에 push -->

<!-- // 			}); -->
			
<!-- // 			if (checkedValue.length == 0) { -->
<!-- // 				alert('입고 확인할 물품을 선택하세요') -->
<!-- // 			} -->
<!-- // 			else { -->
<!-- // 				if(confirm("선택하신 물품을 입고 처리 하시겠습니까?") == true) -->
<!-- // 					{ -->
<!-- // 					    $.ajax({ -->
<!-- // 					       //contentType: "application/json;charset=UTF-8", -->
<!-- // 					       type: "post", -->
<!-- // 					       data: {checkArr: checkedValue}, -->
<!-- // 					       dataType:"text", -->
<!-- // 					       //accept : "application/json", -->
// 					       url: "${pageContext.request.contextPath}/store/receive/confirm",
<!-- // 					       success: function (data) { -->
<!-- // 					          alert('success') -->
<!-- // 					       }, -->
<!-- // 					       error: function() { -->
<!-- // 					           alert('error'); -->
<!-- // 					       } -->
<!-- // 					    }); -->
<!-- // 					} -->
<!-- // 				else { //취소 -->
<!-- // 					location.reload(true); -->
<!-- // 					} -->
<!-- // 		 } -->
<!-- // 	 } -->
<!-- <!-- </script> --> --> --%>

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
/* 			   var order_date = td.eq(3).text();
			   var product_name = td.eq(4).text();
			   var quantity = td.eq(5).text(); */

			   //가져온 값 배열에 담기
			   tdArr.push(order_id);
			   tdArr.push(product_id);
/*			   tdArr[i][0] = order_id;
			   tdArr[i][1] = product_id;
			   console.log("order_id " + order_id + "product_id " + product_id);
 			   tdArr.push(order_date);
			   tdArr.push(product_name);
			   console.log("order_date " + order_date + "product_name " + product_name);
			   tdArr.push(quantity); */

			   
			});
			
			if (checkedValue.length == 0) {
				alert('입고 확인할 물품을 선택하세요')
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
					    	   alert('success');
					    	   location.href='${pageContext.request.contextPath}/store/receive';
					       },
					       error: function() {
					           alert('error');
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
	<table border="0" width="100%">
		<tr align="center">
			<td align="center" width="10%">
				<aside id="left">
					<%@ include file="../left.jsp"%>
				</aside>
			</td>
			<td align="center" width="90%">
				<h4><font color="GREEN">${storeSession.store_name} 입고관리</font></h4>
				<form>
				<table border="1">
					<tr>
						<td><strong>입고여부</strong></td>
						<td><strong>발주번호</strong></td>
						<td><strong>상품번호</strong></td>
						<td><strong>발주날짜</strong></td>
						<td><strong>물품명</strong></td>
						<td><strong>발주수량</strong></td>
					</tr>
					<c:forEach var="receive" items="${receive}">
						<tr>
						<td><input type="checkbox" id="check_receive" name="check_receive" value="${receive.product_name}"></input></td>
							<td><c:out value="${receive.order_id}" /></td>
							<td><c:out value="${receive.product_id}" /></td>
							<td><c:out value="${receive.order_date}" /></td>
							<td><c:out value="${receive.product_name}" /></td>
							<td><c:out value="${receive.quantity}" /></td>
						</tr>
					</c:forEach>
				</table>
				<!-- <input type="submit" value="선택된 물품 입고 확인"/> -->
				</form>
				<%-- <button type="button" id="confirmReceive" name="confirmReceive" onclick="location.href='${pageContext.request.contextPath}/store/receive/confirm'">입고확인</button> --%>
				<button type="button" id="confirmReceive" name="confirmReceive" onclick="post()">입고확인</button>
			</td>
		</tr>
	</table>
</body>

</html>