<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp/UC100/css.jsp"%>
<title>ログアウト</title>
</head>
<body>
<div id="page">
	<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp" %>

 <div class="demo demo5">
            <div class="heading"><span>ログアウト</span></div>
 </div>

<form method="post" action="/tourSystem/FrontCont">
<input type="hidden" name="BUTTON_ID" value="">

	<div style="color:red; font-weight:bold;">
	<c:out value="${requestScope.errorMessage}"></c:out>
	</div>

ログアウトしました。

</form>

</div>
</body>
</html>