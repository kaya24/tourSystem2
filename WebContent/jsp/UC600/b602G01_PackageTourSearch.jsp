<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@include file="/jsp/UC100/css.jsp"%>

<title>パッケージツアー検索</title>
</head>
<body>
<div id="page">
<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp" %>
 <div class="demo demo5">
            <div class="heading"><span>パッケージツアー検索</span></div>
 </div>

<form method="post" action="/tourSystem/FrontCont">
<input type="hidden" name="BUTTON_ID" value="">

<div>
<table>
<tr>
	<td>
	<select name="destination">
		<option value="07">九州</option>
		<option value="01">北海道</option>
		<option value="02">東北</option>
		<option value="03">関東</option>
		<option value="04">中部</option>
		<option value="05">近畿</option>
		<option value="06">四国</option>
		<option value="08">沖縄</option>

	<c:forEach var="obj" items="${PackageTour}">
		<option value=""></option>
	</c:forEach>
	</select>
	</td>
	<td>
	<select name="year">
		<option value="2016">2016</option>
	</select>
	</td>
	<td>
	<select name="month">
		<option value="01">01</option>
	</select>
	</td>
	<td>
	<button class="bt-samp31" type="submit"
	onclick="this.form.BUTTON_ID.value='B602PackageTourSearch';">
      検索
    </button>
	</td>
</tr>
</table>
</div>
</form>
<%@include file="/jsp/UC100/bc000G02_CustFooter.jsp" %>
</div>
</body>
</html>