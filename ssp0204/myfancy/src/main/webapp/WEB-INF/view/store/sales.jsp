<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Calendar cal = Calendar.getInstance();

String strYear = request.getParameter("year");
String strMonth = request.getParameter("month");

//일별 매출 리스트 가져오기
List<Integer> list = (List<Integer>) request.getAttribute("salesbyday");
int monthTotal = (Integer) request.getAttribute("salesbymonth");

int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);
int date = cal.get(Calendar.DATE);

if (strYear != null) {
	year = Integer.parseInt(strYear);
	month = Integer.parseInt(strMonth);

} else {

}
//년도/월 셋팅
cal.set(year, month, 1);

int startDay = cal.getMinimum(java.util.Calendar.DATE);
int endDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
int start = cal.get(java.util.Calendar.DAY_OF_WEEK);
int newLine = 0;

//오늘 날짜 저장.
Calendar todayCal = Calendar.getInstance();
SimpleDateFormat sdf = new SimpleDateFormat("yyyMMdd");
int intToday = Integer.parseInt(sdf.format(todayCal.getTime()));
%>
<html lang="ko">
<HEAD>
<TITLE>매출현황</TITLE>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<style TYPE="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
body {
	scrollbar-face-color: #F6F6F6;
	scrollbar-highlight-color: #bbbbbb;
	scrollbar-3dlight-color: #FFFFFF;
	scrollbar-shadow-color: #bbbbbb;
	scrollbar-darkshadow-color: #FFFFFF;
	scrollbar-track-color: #FFFFFF;
	scrollbar-arrow-color: #bbbbbb;
	margin-left: "0px";
	margin-right: "0px";
	margin-top: "0px";
	margin-bottom: "0px";
}

td {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 9pt;
	color: #595959;
}

th {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #000000;
}

select {
	font-family: 'Jeju Gothic', sans-serif;
	font-size: 15pt;
	color: #595959;
}

.divDotText {
	overflow: hidden;
	text-overflow: ellipsis;
}

A:link {
	font-size: 15pt;
	font-family: 'Jeju Gothic', sans-serif;
	color: #000000;
	text-decoration: none;
}

A:visited {
	font-size: 15pt;
	font-family: 'Jeju Gothic', sans-serif;
	color: #000000;
	text-decoration: none;
}

A:active {
	font-size: 15pt;
	font-family: 'Jeju Gothic', sans-serif;
	color: red;
	text-decoration: none;
}

A:hover {
	font-size: 15pt;
	font-family: 'Jeju Gothic', sans-serif;
	color: red;
	text-decoration: none;
}
</style>
</HEAD>
<BODY>
<aside id="header"> 
	<%@ include file="header.jsp"%>
</aside>
<table border="0" width="100%" align="center">
		<tr align="center">
			<td align="center" width="10%">
			<aside id="left"> 
				<%@ include file="left.jsp"%> 
			</aside>
			</td>
			<td align="center" width="50%">
				<br><br>
				<font color="GREEN" size="8px">${storeSession.store_name} 매출조회</font>
				<br><br><br>
				<form name="calendarFrm" id="calendarFrm" action="" method="post">
					<DIV id="content" style="width: 712px;">

						<!--날짜 네비게이션  -->
						<table width="100%" border="0" cellspacing="1" cellpadding="1"
							id="KOO" bgcolor="#f29886" style="border: 1px solid ##f29886">

							<tr>
								<td height="60">

									<table width="100%" border="0" cellspacing="0" cellpadding="0">
										<tr>
											<td height="10"></td>
										</tr>

										<tr>
											<td align="center"><a
												href="<c:url value='/store/sales' />?year=<%=year - 1%>&amp;month=<%=month%>&amp;lastday=<%=endDay%>"
												target="_self"> <b>&lt;&lt;</b>
												<!-- 이전해 -->
											</a> <%
 	if (month > 0) {
 %> <a
												href="<c:url value='/store/sales' />?year=<%=year%>&amp;month=<%=month-1%>&amp;lastday=<%=endDay%>"
												target="_self"> <b>&lt;</b>
												<!-- 이전달 -->
											</a> <%
 	} else {
 %> <b>&lt;</b> <%
 	}
 %> &nbsp;&nbsp;<font color="black" size="3px"> <%=year%>년 <%=month+1%>월</font>
												&nbsp;&nbsp; <%
 	if (month+1 < 12) {
 %> <a
												href="<c:url value='/store/sales' />?year=<%=year%>&amp;month=<%=month+1%>&amp;lastday=<%=endDay%>"
												target="_self"> <!-- 다음달 -->
													<b>&gt;</b>
											</a> <%
 	} else {
 %> <b>&gt;</b> <%
 	}
 %> <a
												href="<c:url value='/store/sales' />?year=<%=year + 1%>&amp;month=<%=month%>&amp;lastday=<%=endDay%>"
												target="_self"> <!-- 다음해 -->
													<b>&gt;&gt;</b>
											</a></td>
										</tr>
									</table>

								</td>
							</tr>
						</table>
						<br>

						<table border="0" cellspacing="1" cellpadding="1"
							bgcolor="#FFFFFF" align="center">
							<THEAD >
								<TR bgcolor="#CECECE" height="50px">
									<TD width='100px'>
										<DIV align="center">
											<font color="red" size="3px">일</font>
										</DIV>
									</TD>
									<TD width='100px'>
										<DIV align="center"><font size="3px">월</font></DIV>
									</TD>
									<TD width='100px'>
										<DIV align="center"><font size="3px">화</font></DIV>
									</TD>
									<TD width='100px'>
										<DIV align="center"><font size="3px">수</font></DIV>
									</TD>
									<TD width='100px'>
										<DIV align="center"><font size="3px">목</font></DIV>
									</TD>
									<TD width='100px'>
										<DIV align="center"><font size="3px">금</font></DIV>
									</TD>
									<TD width='100px'>
										<DIV align="center">
											<font color="#529dbc" size="3px">토</font>
										</DIV>
									</TD>
								</TR>
							</THEAD>
							<TBODY>
								<TR align="center">
									<%
										//처음 빈공란 표시
									for (int index = 1; index < start; index++) {
										out.println("<TD >&nbsp;</TD>");
										newLine++;
									}

									for (int index = 1; index <= endDay; index++) {
										String color = "";

										// 일요일
										if (newLine == 0) {
											color = "RED";
											// 토요일
										} else if (newLine == 6) {
											color = "#529dbc";
											// 평일
										} else {
											color = "BLACK";
										}
										;

										String sUseDate = Integer.toString(year);

										// 한자리수 달이면 앞에 0붙이기
										sUseDate += Integer.toString(month+1).length() == 1 ? "0" + Integer.toString(month+1)
										: Integer.toString(month+1);
										sUseDate += Integer.toString(index).length() == 1 ? "0" + Integer.toString(index) : Integer.toString(index);

										int iUseDate = Integer.parseInt(sUseDate);

										String backColor = "#EFEFEF";
										if (iUseDate == intToday) {
											backColor = "#c9c9c9";
										}
										out.println("<TD valign='top' align='center' height='92px' size='4px' bgcolor='" + backColor + "' nowrap>");
									%>

									<%
									out.println("<BR>");
									out.println("<H3>" + index + "</H3>");
									// 매출 출력
									if (index <= list.size())
  										out.println(list.get(index-1) + "원");
									%>
									
									<%
									//기능 제거	
									out.println("</TD>");
									newLine++;
									
									if (newLine == 7) {
										out.println("</TR>");
										if (index <= endDay) {
											out.println("<TR>");
										}
										newLine = 0;
									}
									}
									//마지막 공란 LOOP
									while (newLine > 0 && newLine < 7) {
										out.println("<TD>&nbsp;</TD>");
										newLine++;
									}
									%>
								</TR>
								<h2 align="right"><font color="BLUE">월매출: <%out.println(monthTotal); %>원</font></h2>
							</TBODY>
						</TABLE>
					</DIV>
				</form>
			</td>
		</tr>
	</table>

</BODY>
</HTML>
