<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3><font color="red">Error!</font></h3>

<b><c:out value="${message}" default="No further information was provided."/></b>
<br><br>
<a href="${pageContext.request.contextPath}/index">[로그인 페이지로 돌아가기]</a>