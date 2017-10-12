<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp/UC100/css.jsp"%>
<title>FLM Tours</title>
</head>
<body>
	<div id="page">
		<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp"%>

		<div class="demo demo5">
			<div class="heading">
				<span>顧客トップ画面</span>
			</div>
			a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br>
			a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br> a<br>

		</div>

		<form method="post" action="/tourSystem/FrontCont">
			<input type="hidden" name="BUTTON_ID" value="">
			<div>
				<div>パッケージツアー検索はこちら</div>
				<button class="bt-samp31" type="submit" onclick="this.form.BUTTON_ID.value='BC001PackageTour';">検索</button>
			</div>
		</form>

		<%@include file="/jsp/UC100/bc000G02_CustFooter.jsp"%>
	</div>

</body>
</html>