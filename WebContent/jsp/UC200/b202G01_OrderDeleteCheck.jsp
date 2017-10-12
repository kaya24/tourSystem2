<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注文取消</title>
</head>
<body>
	<div id="page">
	<%@include file="/jsp/UC100/bc000G01_CustHeader.jsp" %>
		<div class="demo demo5">
			<div class="heading">
				<span>注文取消</span>
			</div>
		</div>

		<form method="post" action="/tourSystem/FrontCont">
			<input type="hidden" name="BUTTON_ID" value=""> <input
				type="hidden" name="itemCode" value=""> <input type="hidden"
				name="categoryCode" value="">

			<div style="color: red; font-weight: bold;">
				<c:out value="${requestScope.NoShoppingCart}"></c:out>
			</div>
			<div>
				<table>
					<tr>
						<th>選択</th>
						<th>商品コード</th>
						<th>商品名</th>
						<th>料金(円)</th>
						<th>予約人数</th>
						<th>小計(円)</th>
					</tr>
					<tr>
						<td><INPUT type="checkbox" name="chkbutton" value="value1">チェック1</td>
						<td>a</td>
						<td>b</td>
						<td>c</td>
						<td>d</td>
						<td>e</td>
					</tr>
					<tr>
						<td><INPUT type="checkbox" name="chkbutton" value="value2">チェック2</td>
						<td>a</td>
						<td>b</td>
						<td>c</td>
						<td>d</td>
						<td>e</td>
					</tr>
					<tr>
						<td><INPUT type="checkbox" name="chkbutton" value="value3">チェック3</td>
						<td>a</td>
						<td>b</td>
						<td>c</td>
						<td>d</td>
						<td>e</td>
					</tr>
				</table>
			</div>
			<button class="bt-samp31" type="submit"
				onclick="this.form.BUTTON_ID.value='B202OrderDeleteCheck';
									this.form.itemCode.value='<c:out value="${ItemList.itemCode}"></c:out>'">
				取消</button>
		</form>
	</div>
</body>
</html>