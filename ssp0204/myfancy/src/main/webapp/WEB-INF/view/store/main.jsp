<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 메뉴</title>
<style type="text/css">
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);
	section, aside {
		float: left;
		height: 400px;
	}
	aside {
		width: 20%;
		text-align: left;
	}
	section {
		width: 70%;
		text-align: center;
		font-family: 'Jeju Gothic', sans-serif;
	}
	article {
		width: 100%;
	}
</style>
</head>

<!-- <script>
function logout() {
	return logout;
}
</script> -->

<body> 
<%@ include file="header.jsp" %>
<section>
	<article>
	<h2>환영합니다. 오른쪽에서 원하는 메뉴를 선택해주세요.</h2>
	<img src="${pageContext.request.contextPath}/images/logo.gif" width="800" height="600"/>
	</article>
</section>
<aside id = "left">
<%@ include file="left.jsp" %>
</aside>
</body>
</html>