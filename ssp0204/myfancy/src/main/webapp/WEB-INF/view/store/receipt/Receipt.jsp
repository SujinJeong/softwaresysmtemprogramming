<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
   href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css"
   type="text/css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>

<!DOCTYPE html html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>영수증 조회</title>
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
   $(document).ready(
         function() {
            $.datepicker.setDefaults($.datepicker.regional['ko']);
            $("#sale_time")
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
                           dateFormat : "yy-mm-dd",
                           maxDate : 0, // 선택할수있는 최소날짜, ( 0 : 오늘 이후 날짜 선택 불가)
                           onClose : function(selectedDate) {
                           }

                        });
         });

   function msg() {
        if (document.getElementById("sale_id").value == "") {
            alert("판매번호를 입력하세요");
            return false;
        }
        else if (document.getElementById("sale_time").value == "") {
           alert("판매날짜를 입력하세요");
            return false;
            }
        else
            return true;
}
</script>

</head>
<body>

   <aside id="header">
      <%@ include file="../header.jsp"%>
   </aside>
   <table border="0" width="100%">
      <tr align="center">
         <td align="center" width="15%">
            <aside id="left">
               <%@ include file="../left.jsp"%>
            </aside>
         </td>
         <td>
         <font color="GREEN" size="8px">${storeSession.store_name} 영수증 조회</font>
		<br><br><br>
               <form onsubmit="return msg()" action="${pageContext.request.contextPath}/store/receipt/check">
                  판매날짜(YYYY-MM-DD) : <input type="text" name="sale_time" id="sale_time" value="${receipt.sale_time}" />
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
                        <td>
                        <a href="<c:url value='viewReceipt?sale_id=${receipt.sale_id}&sale_time=${receipt.sale_time}'/>">${receipt.sale_id}</a>
                        </td>
                        <td>${receipt.sale_time}</td>
                        <td>${receipt.totalamount}</td>
                     </tr>
                  </c:forEach>
               </table>
         </td>
         <td align="center" width="30%">
         <p><font size="5px" style="background-color:lightgray">상세조회</font></p>
         
         ♥결제내역♥<br>
         -----------------------------------------<br>
         <c:forEach var="searchproduct" items="${searchproduct}" >
            <strong>판매번호:</strong> ${sale_id}<br>
            <strong>상품명:</strong> ${searchproduct.product_name}<br>
            <strong>가격:</strong> ${searchproduct.list_price}<br>
            <strong>수량:</strong> ${searchproduct.quantity}<br>
            <strong>합계:</strong> ${searchproduct.list_price * searchproduct.quantity }
            <br>
            -----------------------------------------<br>
         </c:forEach>
      <br>
   </table>
</body>
</html>