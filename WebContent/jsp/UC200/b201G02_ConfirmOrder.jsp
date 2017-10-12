<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文確認</title>
</head>
<body>
	<div id="page">
		<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp"%>
		<div class="demo demo5">
			<div class="heading">
				<span>注文確認</span>
			</div>
		</div>

		<form method="post" action="/tourSystem/FrontCont">
			<input type="hidden" name="BUTTON_ID" value="">
			<input type="hidden" name="itemCode" value="">

			<div>購入商品情報</div>
			<table>
				<tr>
					<th>商品コード</th>
					<th>商品名</th>
					<th>料金</th>
					<th>予約人数</th>
					<th>小計</th>
				</tr>

				<c:forEach var="itemList" items="${B201ShoppingCart}" varStatus="status">
					<tr>
						<td><a href="/tourSystem/FrontCont?BUTTON_ID=B201CartDetailBack
								&categoryCode=<c:out value="${itemList.categoryCode}"></c:out>
								&itemCode=<c:out value="${itemList.itemCode}"></c:out>">
								<c:out value="${itemList.itemCode}"></c:out>
							</a></td>
						<td><c:out value="${itemList.itemName}"></c:out></td>
						<td class="unitPrice"><fmt:formatNumber value="${itemList.unitPrice}" /></td>
						<td><c:out value="${itemList.quantity}">></c:out></td>
						<td><fmt:formatNumber value="${itemList.subTotal}" /></td>
					</tr>
				</c:forEach>
				<tr>
					<th colspan="4">合計</th>
					<td><fmt:formatNumber value="${B201OrderInfo.orderTotal}" /></td>
				</tr>
			</table>
			<button class="bt-samp31" type="submit" onclick="this.form.BUTTON_ID.value='B201ShoppingCartBack';">戻る</button>
		</form>

	</div>
</body>
</html>