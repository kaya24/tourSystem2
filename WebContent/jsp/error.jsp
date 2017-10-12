<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>システムエラー</title>
</head>
<body>
<div id="page">
<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp" %>
 <div class="demo demo5">
            <div class="heading"><span>システムエラー</span></div>
 </div>

システムエラーが発生しました．
<form method="post" action="/tourSystem/FrontCont">
<input type="hidden" name="BUTTON_ID" value="">



</form>
</div>
</body>
</html>