<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
function msg() {
        if (document.getElementById("card").value == "" || document.getElementById("card").value == 0) {
            alert("카드번호를 올바르게 입력해주세요");
            return false;
  	}
        else
            return true;
}
</script>
<meta charset="UTF-8">
<title>결제창</title>
</head>
<body>
<aside id = "header">
<%@ include file="../header.jsp" %>
</aside>
<h3 align="center" width="10%">통합 결제</h3>
<table border="0" width="150">
   <tr align="center">
      <td align="center" width="10%">
         <aside id = "left">
         <%@ include file="../left.jsp" %>
         </aside>
      </td>
      <!-- 여기까지는 왼쪽 메뉴 출력 -->
   <form:form name="payment1" modelAttribute="payment" method="post" onsubmit="return msg()" action="${pageContext.request.contextPath}/store/sale/payment?payment_code=${payment.payment_code + 1 }"> 
      <td align="center" width="10%">
         <table style="width:70%">
            <tr><th>결제할 금액</th>
               <td align="center" width="80%">
               <form:input path="amount" name="amount" value="${payment.amount}"/>
               </td>
            </tr>
            <c:if test="${codename eq '카드결제' }">
            <tr><th>카드번호</th>
               <td align="center" width="80%"><form:input id="card" path="card_num" name="card_num" value="${payment.card_num }"/></td>
            </tr> 
            </c:if>
            <tr>
            <td align="center" width="45%">
            <input type="${type }" value="${codename }" onClick="msg()" />   
      </form:form>
            </td>      
         </tr>
         </table>
      </td>
      <!-- 여기까지 가운데 화면 -->
      <td>
         <form:form modelAttribute="payment" method="post" action="receipt">
         <table style="width:70%">
            <tr><th>총${sessionSaleCart.cartTotalQuantity}개</th>
            <td>${sessionSaleCart.getSubSaleTotal()}</td></tr>
            <tr><th>결제한 금액</th>
            <td>${sessionSaleCart.getSubSaleTotal()-payment.amount}</td></tr>
            <tr><th>남은 금액</th>
            <td>${payment.amount}</td></tr>
            <tr><th>현금 결제</th>
            <td>${payment.cashAmount}</td></tr>
            <tr><th>카드 결제</th>
            <td>${payment.cardAmount}</td></tr>
            <tr>
               <td align="center" width="45%">
                  <input type="button" value="취소" onclick="location.href='${pageContext.request.contextPath}/store/sale/remove'"/>
               </td>
               <td align="center" width="45%">
                  <input type="submit" value="결제완료"/>
               </td>
            </tr>
         </table>
      </td>
      </form:form>
</table>
</body>
</html>