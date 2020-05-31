<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>로그인</title>
    </head>
    <body>
	    <div align="center">
	    	<h1>Fancy Shop POS System</h1>
	    	<form method="post" action="main">
			ID : <input type="text" name="id" />
			<br /><br />
	
			PW : <input type="password" name="pw" />
			<br /><br />
			
			<input type="submit" value="로그인" />

			</form>
    	</div>
	</body>
</html>
