<%@page import="java.util.Date, java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	Date date = new Date();
	String year = yearFormat.format(date);
	SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
	String month = monthFormat.format(date);
%>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/store/emp/employer'">직원관리</button>
<button type="button" onclick="location.href='${pageContext.request.contextPath}/store/emp/employer/salary?move=0&year=<%=year%>&month=<%=month%>'">급여관리</button>