<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パッケージツアー商品一覧</title>
</head>
<body>
<div id="page">
<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp" %>
 <div class="demo demo5">
            <div class="heading"><span>パッケージツアー商品一覧</span></div>
 </div>

<form method="post" action="/tourSystem/FrontCont">
<input type="hidden" name="BUTTON_ID" value="">
<input type="hidden" name="itemCode" value="">

<div>
<table>
<tr>
	<th>地区名</th>
	<td><c:out value="${requestScope.DestinationName}"></c:out></td>
</tr>
<tr>
	<th>開催日</th>
	<td><c:out value="${requestScope.Year}"></c:out>年／<c:out value="${requestScope.Month}"></c:out>月</td>
</tr>
</table>
</div>

<!-- パッケージツアー販売商品一覧表示 -->
<div>
<table>
<c:forEach var="packageTour" items="${requestScope.PackageTourList}" varStatus="count">
	<tr>
		<th>商品コード</th>
		<td>
		<a href="/tourSystem/FrontCont?BUTTON_ID=B602PackageTourListDetail
		&itemCode=<c:out value="${packageTour.itemCode}"></c:out>">
		<c:out value="${packageTour.itemCode}"></c:out>
		</a>
		</td>
	</tr>
	<tr>
		<th>商品名</th>
		<td><c:out value="${packageTour.itemName}"></c:out></td>
	</tr>
	<tr>
		<th>料金</th>
		<td><c:out value="${packageTour.unitPrice}"></c:out></td>
	</tr>
	<tr>
		<th>在庫</th>
		<td><c:out value="${packageTour.stock}"></c:out></td>
	</tr>

</c:forEach>
</table>
</div>
<div>


</div>

</form>
</div>
</body>
</html>