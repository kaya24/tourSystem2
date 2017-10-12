<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>パッケージツアー商品詳細</title>
</head>
<body>
	<div id="page">
		<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp"%>
		<div class="demo demo5">
			<div class="heading">
				<span>パッケージツアー商品詳細</span>
			</div>
		</div>


		<form method="post" action="/tourSystem/FrontCont">
			<div style="color: red; font-weight: bold;">
				<c:out value="${requestScope.PutCartMessage}"></c:out>
			</div>

			<input type="hidden" name="BUTTON_ID" value="">
			<input type="hidden" name="categoryCode"
				value="<c:out value="${requestScope.PackageTour.categoryCode}"></c:out>">
			<input type="hidden" name="date"
				value="<c:out value="${requestScope.PackageTour.date}"></c:out>">
			<input type="hidden" name="destination"
				value="<c:out value="${requestScope.PackageTour.destinationCode}"></c:out>">
			<input type="hidden" name="itemCode"
				value="<c:out value="${requestScope.PackageTour.itemCode}"></c:out>">
			<input type="hidden" name="itemName"
				value="<c:out value="${requestScope.PackageTour.itemName}"></c:out>">
			<input type="hidden" name="unitPrice"
				value="<c:out value="${requestScope.PackageTour.unitPrice}"></c:out>">
			<input type="hidden" name="stock"
				value="<c:out value="${requestScope.PackageTour.stock}"></c:out>">

			<table>
				<tr>
					<th>商品コード</th>
					<td><c:out value="${requestScope.PackageTour.itemCode}"></c:out></td>
				</tr>
				<tr>
					<th>商品名</th>
					<td><c:out value="${requestScope.PackageTour.itemName}"></c:out></td>
				</tr>
				<tr>
					<th>料金</th>
					<td><c:out value="${requestScope.PackageTour.unitPrice}"></c:out></td>
				</tr>
				<tr>
					<th>在庫</th>
					<td><c:out value="${requestScope.PackageTour.stock}"></c:out></td>
				</tr>
			</table>

			<%--ボタン配置 --%>
			<table>
				<tr>
					<td>
						<button class="bt-samp31" type="submit"
							onclick="this.form.BUTTON_ID.value='B601DetailListBack';">
							戻る</button>
					</td>
					<td>
						<button class="bt-samp31" type="submit"
							onclick="this.form.BUTTON_ID.value='B601DetailPutCart';">
							カートに入れる</button>
					</td>
					<td>
						<button class="bt-samp31" type="submit"
							onclick="this.form.BUTTON_ID.value='B601DetailViewCart';">
							カートを見る</button>
					</td>
				</tr>
			</table>

		</form>
	</div>
</body>
</html>